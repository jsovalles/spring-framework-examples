# spring-boot-horario
Spring MVC proyect with examples on how to defines the different errors that a program can have
(such as nullPointerException, ArithmeticError... etc)
# Notes

```
ErrorHandlerController -- controller class that will be used for the different error that the application might  have
Must be used with @ControllerAdvice to manage the warnings/errors

@ExceptionHandler("ArithmeticException.class") -- defines the exception that will be handled on the controller class

There is an option for the errors with Optional from Java 8
returns empty if its null or the value otherwise
we use lambda for that example
```

# Built With

* [Spring STS](https://spring.io/tools) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK

