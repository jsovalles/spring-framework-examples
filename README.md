# spring-boot-form
Spring MVC proyect with an example of Spring annotations, validations and thymeleaf/Bootstrap front annotations

# Notes

```
@Valid -- Valids the objects

@NotEmpty -- checks if the variable is not null and if it has a length

BidingResult -- must be used with @Valid, and must go after the corresponding objects

@ModelAttribute("name") -- renames an object value that is implemented on the view

th:text="${text}" -- implements whats inside text from the Model object from the controller

th:action="@/form" method="post" -- defines to what request the user will load on the view if it shares the same URI, in this case is POST

th:object="${object}" -- defines the object that is gonna be used on the form (or other html function)

type="text" (or password/email) -- defines the field type

th:field ="*{value}" -- needs to be used with th:object, calls the variables from the object basically

"${#fields.hasErrors('value')}" -- checks if the variable has any error (example if its null)

th:errors="*{value}" -- prints the error from the corresponding value

@SessionAttributes("object") -- makes an object persistant only on a session, you must enter the specific object

SessionStatus -- making operation with the corresponding session

@Email -- checks if the value has email format

@Size(min=3,max=8) -- checks if the value has the determined size

messages.properties -- file to control the errors that the program may have on the view

the properties file must be on UTF-8 for spanish accents

@Pattern(regexp = "") -- verifies if the pattern has a corresponding regular exppression (ex: "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}"

Validator interface -- Helps with validation of objects

ValidationUtils -- multiple aplications for validations of variables

@NotBlack -- validates if the variable has whitespaces and if its null

@InitBinder -- other way to validate the corresponding fields from a form

You most add validators but not set validators, if you set it will override the other validators

@Constraints -- adds custom annotations for validation or other implementations

@Min/@Max -- checks if the value (number) is between a corresponding value

@DateTimeFormat(pattern = "yyyy/MM/dd") -- puts the corresponding date on the format that is needed

@Past @Future -- validates the date that is declared, must be according to the annotation

InitBinder can be used to change the format of the corresponding inputs, like Dates

for HTML5 use this kind of dates (yyyy-MM-dd) (makes sense for backend as well)

package editors -- examples of multiple types of editors, such as making all the names starting with Uppercase

th:each="country : ${countries}" -- for each with Thymeleaf

th:text="${#dates.format(date),''dd-MM-yyyy} -- thymeleaf have an option to change the date format, depending on what you want to see on the front

If you want more information about thymeleaf view usages for any type visit the website

To avoid POST multiple consumes you must redirect to the other URI, mostly to avoid multiple duplicates on the database

Once you end the form process it will only show on the GET on the redirect, since its only a session object and will be destroyed after its completed
So, if someone wants to reload the GET it will redirect to the form (POST) so they can start over again
For future references, it can be redirected with the ID if the corresponding form/user, but since we're not working with database it can't be done
```

# Built With

* [Spring STS](https://spring.io/tools) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK

