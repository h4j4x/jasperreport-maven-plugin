# Jasper Report Maven Plugin

[![Build Status](https://travis-ci.org/miche-atucha/jasperreport-maven-plugin.svg?branch=master)](https://travis-ci.org/miche-atucha/jasperreport-maven-plugin)

[![](https://jitpack.io/v/miche-atucha/jasperreport-maven-plugin.svg)](https://jitpack.io/#miche-atucha/jasperreport-maven-plugin)

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
