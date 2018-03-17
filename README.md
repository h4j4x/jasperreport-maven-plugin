# Jasper Report Maven Plugin

[![Build Status](https://travis-ci.org/miche-atucha/jasperreport-maven-plugin.svg?branch=master)](https://travis-ci.org/miche-atucha/jasperreport-maven-plugin) [![](https://jitpack.io/v/miche-atucha/jasperreport-maven-plugin.svg)](https://jitpack.io/#miche-atucha/jasperreport-maven-plugin)

Compiles .jrxml to .jasper.

## Usage

### JitPack

```xml
<project>
    ...
    <pluginRepositories>
        <pluginRepository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </pluginRepository>
    </pluginRepositories>

    <build>
        <plugins>
            <plugin>
                <groupId>com.github.miche-atucha</groupId>
                <artifactId>jasperreport-maven-plugin</artifactId>
                <version>0.0.2</version>
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
    ...
</project>
```
