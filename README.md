# Spring-MVC-Example

Basic use of Spring MVC

# What is MVC
[Link](https://www.javatpoint.com/spring-mvc-tutorial)

# Deploy with CMD

```
.\mvnw.cmd package -- Download the corresponding maven dependencias and creates the corresponding JAR on target (mvn install from the IDE works as well)

java -jar .\target\{PACKAGE_NAME} -- Deploys the jar with the console (can be done with VPS and SSH)
```

# Built With

* [Spring STS](https://spring.io/tools) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK

# Redirect and forward

* redirect: takes the value to redirect ("index" or can use a third-party ("https:www.google.com")
* forward: takes the value to redirect but the URI stays the same, useful for HOME URIs, can't use third-party

