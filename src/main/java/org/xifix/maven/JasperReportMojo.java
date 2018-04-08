
package org.xifix.maven;

import java.io.File;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate-jasper")
public class JasperReportMojo extends AbstractMojo
{
    @Parameter(required = true)
    private File sourceDir;

    @Parameter(required = true)
    private File outputDir;

    public void execute()
    {
        //noinspection ResultOfMethodCallIgnored
        outputDir.mkdirs();
        getLog().info(String.format("Processing directory: %s", sourceDir.getAbsolutePath()));
        int processed = processFiles(sourceDir);
        getLog().info(String.format("Generated %d files in %s.", processed, outputDir.getAbsolutePath()));
    }

    private int processFiles(File directory)
    {
        int processed = 0;
        File[] files = directory.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    processed += processFiles(file);
                }
                else if (processJrxml(file))
                {
                    processed++;
                }
            }
        }
        return processed;
    }

    private boolean processJrxml(File source)
    {
        String ext = ".jrxml";
        if (!source.getName().endsWith(ext))
        {
            return false;
        }

        getLog().info(String.format("Compiling %s...", source.getName()));
        String sourcePath = source.getAbsolutePath();
        String targetPath = sourcePath.substring(sourceDir.getAbsolutePath().length());
        File target = new File(outputDir, targetPath.replace(ext, ".jasper"));
        //noinspection ResultOfMethodCallIgnored
        target.getParentFile().mkdirs();
        try
        {
            JasperCompileManager.compileReportToFile(sourcePath, target.getAbsolutePath());
            getLog().info(String.format("Generated %s.", target.getName()));
            return true;
        }
        catch (JRException ex)
        {
            String message = String.format("Could not process %s, error: %s",
                                           source.getName(), ex.getMessage());
            getLog().error(message);
            return false;
        }
    }
}
