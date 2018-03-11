
package org.xifix.maven;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import org.apache.maven.plugin.AbstractMojo;
import java.io.File;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate-jasper")
public class JasperReportMojo extends AbstractMojo
{
    @Parameter(required = true)
    private File sourceDir;

    @Parameter(defaultValue = "${project.build.outputDirectory}/jasper")
    private File outputDir;

    public void execute()
    {
        if (!outputDir.exists())
        {
            //noinspection ResultOfMethodCallIgnored
            outputDir.mkdirs();
        }
        getLog().info(String.format("Processing directory: %s", sourceDir.getAbsolutePath()));
        int processed = processFiles(sourceDir);
        getLog().info(String.format("Generated %d files in %s.", processed, outputDir.getAbsolutePath()));
    }

    private int processFiles(File directory)
    {
        File[] files = directory.listFiles();
        if (files == null)
        {
            return 0;
        }

        int processed = 0;
        for (File file : files)
        {
            if (file.isDirectory())
            {
                processed += processFiles(file);
            }
            else if (file.getName().endsWith(".jrxml"))
            {
                if (processJrxml(file))
                {
                    processed++;
                }
            }
        }
        return processed;
    }

    private boolean processJrxml(File source)
    {
        getLog().info(String.format("Compiling %s...", source.getName()));
        String sourcePath = source.getAbsolutePath();
        String targetPath = sourcePath.substring(sourceDir.getAbsolutePath().length());
        File target = new File(outputDir, targetPath.replace(".jrxml", ".jasper"));
        //noinspection ResultOfMethodCallIgnored
        target.getParentFile().mkdirs();
        try
        {
            JasperCompileManager.compileReportToFile(sourcePath, target.getAbsolutePath());
            getLog().info(String.format("Generated %s.", target.getName()));
            return true;
        }
        catch (JRException e)
        {
            getLog().error(String.format("Could not process %s", source.getName()));
            return false;
        }
    }
}
