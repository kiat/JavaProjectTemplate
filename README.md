# Project Template

This is a Java Maven Project Template


# How to compile the project


[![Build Status](https://travis-ci.org/kiat/JavaProjectTemplate.svg?branch=master)](https://travis-ci.org/kiat/JavaProjectTemplate)  

[![Coverage Status](https://coveralls.io/repos/github/kiat/JavaProjectTemplate/badge.svg?branch=master)](https://coveralls.io/github/kiat/JavaProjectTemplate?branch=master)

[![sonarcloud](https://sonarcloud.io/api/project_badges/measure?project=edu.bu.cs665%3AExample-1&metric=alert_status)](file:https://sonarcloud.io/api/project_badges/measure?project=edu.bu.cs665%3AExample-1&metric=alert_status)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)


We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```


```bash
java -Dlog4j.configuration=file:log4j.properties -classpath target/Example-1-1.0-SNAPSHOT-jar-with-dependencies.jar edu.bu.met.cs665.Main
```


# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```

# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


