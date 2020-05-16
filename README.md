# Spring-boot-di

Basic use of Spring with dependency injections

# Injection descriptions

```
@Controller -- makes the class a controller MVC, this class will work for Model and view and will have the corresponding requests

@GetMapping("/") -- Indicates the URI for the service, it can implements multiple URI with an array ({"/ej1", "ej2"})

service package -- works with DAO or API Rest for the different services/databases

@Component -- used for DTO/Beans to inject on different classes (@Component("myComponent")

@Service -- same as component, but is more a semantic use (Business Service Facade) for service logic (FACADE)

@Repository -- for persistance, DAOs

@Autowired -- injects an object that is registered on Spring container (component or service as an example)

interface -- contains the method that will be implemented on the service ( Class implements IClass)

@Override -- override the corresponding method

@Resource -- injects the corresponding method/classes obtained from @Component

@Component and @Resource can both work with each other, other method is with @Autowired and @Qualifier, but is the same

@Primary -- if two beans have the same Interface and method using Primary will make them the default injection bean

@Qualifier -- same use as primary but it must be declared with @Autowired and the name of the component bean (@Qualifier("myComponent"))

@Configuration and @Bean does the same as @Component, is useful to declares each class one by one (API REST)

@Value(${client.name}) -- returns the value from the backets that is defined on the properties file...

@PostConstruct -- Executes after the injection of dependencies, is similar as a constructor

@PreDestroy -- Acts as a singleton, will work until an undeploy or stop on STS

All that is defined on the Controller class needs to be stateless, it can't contain crucial data (like Client data)

@RequestScope -- it will last as much as the HTTP request, then it will destroy, it will be unique as you consume a request

@SessionScope -- works on a session, will end when the navigator is closed or if there is a timeout, must implement Serializable, the scope depends on the Servlet

@ApplicationScope -- similar as a singleton, servletContext
```

# Built With

* [Spring STS](https://spring.io/tools) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK

