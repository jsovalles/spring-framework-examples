# spring-boot-horario
Spring MVC proyect with an example of interceptors usages

# Notes

```
In this example we have two methods /index and /cerrado and the proyect works as follows:

if an user enters to the corresponding website on a certain hour (defined on properties file) it will link
to either index (working hour) or cerrado (closed hour)

for the values of working hour and closed hours we use the Integers apertura/cierra from the controller class
and with @Value we obtain the corresponding hour values that were defined on the properties file in resources

We use a StringBuilder to append a text (so we don't instance a String multiple times) that will show on the view
AKA index.html or cerrado.html

We create the class Interceptor for the preHandle and postHandle of the current Web service
we have the if condition that will return true on the preHandle if the hours are according to the working hours
(and will redirect to the index)
After that, on the postHandle we get the attribute message that we sended on the preHandle and we set it on the view
(on the index basically), showing the message on the html file.

However if the hours doesn't apply we will send a redirect (on the code) to the cerrado URI and we will return a false,
meaning that the conditions didn't apply and will never access postHandle methods

Reminder: to apply the custom interceptors we gotta use the MvcConfig class and declare it on the addInterceptor method from registry.

NOTE: There was an error on the interceptor that if the hours didn't apply it will create an infinite loop on the cerrado HTTP method, to solve
the issue we needed to exclude the corresponding path from the interceptors, since the created interceptor will only apply on the main file (index)

```

# Built With

* [Spring STS](https://spring.io/tools) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK

