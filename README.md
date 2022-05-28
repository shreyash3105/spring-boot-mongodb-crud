# spring-boot-mongodb-crud

This project explains CRUD (**C**reate, **R**ead, **U**pdate, **D**elete) operations using MongoTemplate and MongoRepository using spring boot and mongo DB.
In this app we are using Spring Data JPA for built-in methods to do CRUD operations and Mongo queries using MongoTemplate.     
`@EnableMongoRepositories` annotation is used on main class to Enable Mongo related configuration, which will read properties from `application.properties` file.



## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Mongo DB](https://docs.mongodb.com/guides/)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)


## Tools
- Eclipse or IntelliJ IDEA or STS (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)


<br/>


###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-mongodb**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application
or
> **```mvn clean install```** it will build application and create **jar** file under target directory 
Run jar file from below path with given command
> **```java -jar ~/path-to-spring-boot-mongodb/target/spring-boot-mongodb-0.0.1-SNAPSHOT.jar```**
Or
> run main method from `SpringBootMongoDBApplication.java` as spring boot application.  

||
|  ---------    |
| **_Note_** : In `SpringBootMongoDBApplication.java` class we have autowired both SuperHero and Employee repositories. <br/>If there is no record present in DB for any one of that module class (Employee or SuperHero), static data is getting inserted in DB from `HelperUtil.java` class when we are starting the app for the first time.| 



### Code Snippets
1. #### Maven Dependencies
    Need to add below dependencies to enable Mongo related config in **pom.xml**. Lombok's dependency is to get rid of boiler-plate code.   
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```
   
   
2. #### Properties file
    Reading Mongo DB related properties from **application.properties** file and configuring Mongo connection factory for mongoDB.  

    **src/main/resources/application.properties**
     ```
    spring.data.mongodb.uri = 
    spring.data.mongodb.database = spring_boot_mongo_app
     ```
   
   
3. #### Model class
    Below are the model classes which we will store in MongoDB and perform CRUD operations.  
    **com.spring.mongo.demo.model.SuperHero.java**  
    ```
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document(collection = "super_hero")
    public class SuperHero implements Serializable {
    
        @Id
        private String id;
        private String name;
        private String superName;
        private String profession;
        private int age;
        private boolean canFly;
    }
    ```
   
4. #### CRUD operations

    In **com.spring.mongo.demo.controller.SuperHeroController.java** class, 
    we have exposed 5 endpoints for basic CRUD operations
    - GET All Super Heroes
    - GET by ID
    - POST to store Super Hero in DB
    - PUT to update Super Hero
    - DELETE by ID
    
    ```
    @RestController
    @RequestMapping("/super-hero")
    public class SuperHeroController {
        
        @GetMapping
        public ResponseEntity<List<?>> findAll();
    
        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable String id);
    
        @PostMapping
        public ResponseEntity<?> save(@RequestBody SuperHero superHero);
    
        @PutMapping
        public ResponseEntity<?> update(@RequestBody SuperHero superHero);
    
        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable String id);
    }
    ```
   
    In **com.spring.mongo.demo.repository.SuperHeroRepository.java**, we are extending `MongoRepository<Class, ID>` interface which enables CRUD related methods.
    ```
    public interface SuperHeroRepository extends MongoRepository<SuperHero, String> {
    }
    ```
   
   In **com.spring.mongo.demo.service.impl.SuperHeroServiceImpl.java**, we are autowiring above interface using `@Autowired` annotation and doing CRUD operation.


 
    
### API Endpoints

- #### Super Hero CRUD Operations
    > **GET Mapping** http://localhost:8080/super-hero  - Get all Super Heroes
    
    > **GET Mapping** http://localhost:8080/super-hero/5f380dece02f053eff29b986  - Get Super Hero by ID
       
    > **POST Mapping** http://localhost:8080/super-hero  - Add new Super Hero in DB  
    
      Request Body  
      ```
        {
            "name": "Tony",
            "superName": "Iron Man",
            "profession": "Business",
            "age": 50,
            "canFly": true
        }
      ```
    
    > **PUT Mapping** http://localhost:8080/super-hero  - Update existing Super Hero for given ID 
                                                       
      Request Body  
      ```
        {
            "id": "5f380dece02f053eff29b986"
            "name": "Tony",
            "superName": "Iron Man",
            "profession": "Business",
            "age": 50,
            "canFly": true
        }
      ```
    
    > **DELETE Mapping** http://localhost:8080/super-hero/5f380dece02f053eff29b986  - Delete Super Hero by ID
