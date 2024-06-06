---------------------------------
MongoDB + SpringBoot Backend Notes + Tutorial with Frontend and Backend examples

----------------------------------


Q Where do springboot properies and application.properties come from?
- From the src/resources/application.properties file in the springboot jar package

Q Static and templates folder are for what in Springboot?
- Static folder is for static resources like css, js, images, html.
- Web development stuff

Q What is getMapping and postMapping in Springboot?
- getMapping is for getting data from the server
- postMapping is for sending data to the server
- basically they are post and get requests in Springboot

Q What is the difference between @RestController and @Controller in Springboot?
- @RestController is used to create RESTful web services
- @Controller is used to create web applications

Q What is autowired in Springboot?
- Autowired is used to inject a bean into a class
- Beans are objects that are managed by the Spring application context
- Basically, instantiate a class without using the new keyword

Q what are spring beans in Springboot?
- Spring beans are objects that are managed by the Spring application context
- Beans are created by the Spring container and are autowired into classes


Q Difference between @Service and @Component in Springboot?
- @Service is a specialization of @Component
- @Service is used to annotate classes that perform service tasks
- @Component is a generic stereotype for any Spring-managed component

Q How to connect MongoDB with Springboot?
- Go to application.properties and add the following:
- spring.data.mongodb.uri=yourMongoDBURI
- spring.data.mongodb.database=yourDBName 

Q How do you store private information like URIs and Sensitives in Springboot?
- Use a .env file to store your private variables
- .env file goes in resources folder in main.

Q How to use .env file in Springboot?
- Must install dependency spring-dotenv from maven dependencies online.
- Add dependencies in pom.xml file
- Call with ${variableName} in application.properties file

Q What does the @Document annotation do in Springboot?
- @Document is used to specify the name of the collection in MongoDB
- @Document(collection = "collectionName")

Q What does the @Id annotation do in Springboot?
- @Id is used to specify the primary key of the document in MongoDB
- Denotes the Id of the document

Q What does the AllArgs, NoArgs, and Data annotation do in Springboot from Lombok?
- Reduces boilerplate code
- @Data is a shortcut for @ToString, @EqualsAndHashCode, @Getter, @Setter, and @RequiredArgsConstructor
- @NoArgsConstructor creates a no-args constructor
- @AllArgsConstructor creates a constructor with all args

Q What does @DocumentReference do in Springboot?
- @DocumentReference is used to reference another document in MongoDB
- @DocumentReference is used to create a relationship between two documents

Q What is the difference between Repository, Controllers, Application, and Service files in Springboot?
- Repository is used to interact with the database (connect to)
- Controllers are used to handle incoming requests (routes)
- Application is used to run the Springboot application
- Service is used to perform business logic for the application

Q What dos the @Repository annotation do in Springboot?
- @Repository is used to indicate that the class provides the mechanism for storage, retrieval, search, update, and delete operation on objects

Q What does the @Service annotation do in Springboot?
- @Service is used to indicate that the class provides some business functionalities

Q What does the Optional class do in Java?
- Optional is a container object that may or may not contain a non-null value

Q How to pass in dynamic routing, i.e. /api/{id} in Springboot?
- Use @PathVariable annotation in the method parameter
- @GetMapping("/api/{id}")
- public String get(@PathVariable String id) {
  return id;
}


Q List useful mongoDB operations in Springboot and their meanings
- findAll() - returns all documents in the collection
- findById() - returns a document by its id
- save() - saves a document to the collection
- deleteById() - deletes a document by its id
- insert() - inserts a document to the collection
- count() - returns the number of documents in the collection
- existsById() - checks if a document exists by its id
- deleteAll() - deletes all documents in the collection
- delete() - deletes a document
- exists() - checks if a document exists

Q List useful mongoTemplate operations in Springboot and their meanings
- find() - finds documents in the collection
- findOne() - finds one document in the collection
- update() - updates a document in the collection
- remove() - removes a document from the collection
- insert() - inserts a document to the collection
- findAll() - finds all documents in the collection
- findAndModify() - finds and modifies a document in the collection
- findAndRemove() - finds and removes a document from the collection
- count() - returns the number of documents in the collection
- exists() - checks if a document exists in the collection
- dropCollection() - drops the collection
- createCollection() - creates a collection
- getCollection() - gets the collection
- collectionExists() - checks if the collection exists
- matching() - matches documents in the collection
- apply() - applies an operation to the collection
- first() - finds the first document in the collection

Q What is the difference between mongoTemplate and mongoRepository in Springboot?
- MongoRepository is a high-level abstraction that provides CRUD operations
- MongoTemplate is a low-level abstraction that provides more flexibility and control over the operations

Q What is the difference between @Query and @QueryAnnotation in Springboot?
- @Query is used to define a custom query in the repository interface
- @QueryAnnotation is used to define a custom query in the repository interface

Q MongoDB vs SQL databases
- MongoDB is a NoSQL database that stores data in a document format
- SQL databases store data in tables and rows
- MongoDB is more flexible and scalable than SQL databases
- SQL databases are more structured and have a fixed schema
- MongoDB is better suited for unstructured data# MongoDBSpringBootTutorial
# MongoDBSpringBootTutorial
