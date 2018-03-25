---
layout: default
title: Jasper Report Maven Plugin
description: Compiles JRXML files (JasperReports XML templates) to .jasper files.
---

[![Build Status](https://travis-ci.org/miche-atucha/jasperreport-maven-plugin.svg?branch=master)](https://travis-ci.org/miche-atucha/jasperreport-maven-plugin) [![](https://jitpack.io/v/miche-atucha/jasperreport-maven-plugin.svg)](https://jitpack.io/#miche-atucha/jasperreport-maven-plugin)

[JasperReports](https://community.jaspersoft.com/project/jasperreports-library)is an open source Java reporting tool that can write to a variety of targets, such as: screen, a printer, into PDF, HTML, Microsoft Excel, RTF, ODT, Comma-separated values or XML files.
## Maven usage
### Maven Repository
[Maven Central Repository](https://mvnrepository.com/) is the largest repository of components aimed at Java/JVM-based development and beyond.
```xml
<project>
    ...
    <build>
        <plugins>
            <plugin>
                <groupId>org.xifix.maven</groupId>
                <artifactId>jasperreport-maven-plugin</artifactId>
                <version>0.0.3</version>
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
### JitPack
[JitPack](https://jitpack.io/) is a novel package repository for JVM and Android projects. It builds Git projects on demand and provides you with ready-to-use artifacts (jar, aar).
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
