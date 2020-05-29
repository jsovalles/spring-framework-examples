# spring-boot-h2-example
Spring MVC proyect using JPA and H2 memory database

# Notes

```
Spring MVC proyect Using JPA and SQL/H2 Database

@Entity -- Declaring a class an entity class for the database

@Table(name="clients") -- declaring the database table

@Id -- indicates that the value is the primary key

@GeneratedValue(strategy=GenerationType.IDENTITY) -- strategy that the key will be created

@Column(name="name_database") -- used te reference the name of the database if its different on the entity variable

@Temporal(TemportalType.DATE) -- indicates the format that will be saved on the database

@Repository -- defines the class as a persistance component of data access

EntityManager -- helps to manage the identity classes

@Transaction -- makes the method transactional, it can be readOnly

@PersistenceContext -- will inject the dependencies on the EntityManager, in this case H2

http://localhost:8080/h2-console -- entering the H2 console, must be enabled on the application.properties

.persist -- saves an entity object in the persistance context and on the database

@Prepersist -- methods that we need to do before saving on a database (example getting a certain date)

.merge -- Updates the values that already exist on the database

.remove -- removes the corresponding object/values from the database

CrudRepository -- STS interface that has different methods for a CRUD system

@Query -- uses DB Querys, must implement Entities from the current proyect

Query Creation -- you can create your own querys from Spring
example (findByEmailAddress) -- findBy is reserved by Spring and EmailAddress is the attribute we want to look
```

# Built With

* [Spring STS](https://spring.io/tools) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* Java 11 JDK

