# Jasper Report Maven Plugin
Compiles .jasper from .jrxml.

## Usage
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.xifix.maven</groupId>
            <artifactId>jasperreport-maven-plugin</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <executions>
                <execution>
                    <id>process</id>
                    <phase>generate-resources</phase>
                    <goals>
                        <goal>generate-jasper</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <sourceDir>${project.basedir}/src/main/resources/reports</sourceDir>
                <outputDir>${project.build.outputDirectory}/reports</outputDir>
            </configuration>
        </plugin>
    </plugins>
</build>
```
