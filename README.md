6/6/24 CHANGELOG MiguelsBranch
- Used Spring initialzr to get running project and placed folders inside main program. 
- Changed package names to match spring initialzr package name
- Converted class constructors into Lombok (creates getters, setters, toString, etc. automatically) to reduce boilerplate.
- Converted book and user dummy data to JSON for easy import into MongoDB Compass
- Added more dummy users for testing and created test endpoints for getting all users and getting a user by _id
- Changed variables to match as Java wanted specifics (I.e. isbn -> ISBN in some cases).
- Created userID as it just had _id, which may be confusing, (i.e. a book can have an _id), but _id will still remain as the object identifying ID.
- Moved dummyData into own subfolder
- Added more dummy data for testing

How to run:
1. Clone the repository
2. Open the project in IntelliJ or your preferred IDE
3. Get your MongoDB URI from MongoDB Compass after you've created a Cluster. It should look something like this:
    mongodb+srv://<username>:<password>@<cluster>/<database>

4. Create .env file in resources folder of Library_API and add the following line (not last line):
    - MONGO_DATABASE=<yourDatabaseName>
    - MONGO_USER=<yourDatabaseUsername>
    - MONGO_PASSWORD=<yourDatabasePassword>
    - MONGO_CLUSTER=<yourDatabasePassword>
    - MongoDB URI Example: mongodb+srv://${MONGO_USER}:${MONGO_PASSWORD}@${MONGO_CLUSTER}/
      
5. Go to database in MongoDB Compass and create two new collections, one called "books" and the other called "users"
6. Import the dummy data from the dummyData folder into the respective collections
7. Run the project from "src/main/java/bookstore_group3/Library_API/LibraryApiApplication.java" and test desired endpoints in Postman or localhost:8080
