# **Project Overview**

Geek Text is an online bookstore API designed to support an application targeting a niche in technology books. This API allows users to browse and sort books, manage their profiles, handle shopping cart operations, view book details, rate and comment on books, and manage wishlists.

  ![enter image description here](https://www.shareicon.net/data/256x256/2016/07/31/804508_book_512x512.png)



## Features


 - Book Browsing and Sorting
 - Retrieve List of Books by Genre: Allows users to get a list of books    within a specific genre.
 - Retrieve List of Top Sellers: Returns the top 10 books that have sold    the most copies.
 - Retrieve List of Books by Rating: Filters and returns books with a    rating equal to or higher than a specified value.
 - Discount Books by Publisher: Updates the price of all books from a    particular publisher by a specified discount percentage.

  

**Profile Management**

- Create a User: Enables users to create a profile with a username, password, and optional personal information.
- Retrieve User Profile: Allows users to fetch their profile information using their username.
- Update User Profile: Lets users update their profile information except for their email address.
- Create Credit Card for User: Associates a credit card with the user's profile.

  

**Shopping Cart**

- Retrieve Subtotal: Provides the subtotal price of all items in a user’s shopping cart.
Add Book to Cart: Adds a book to the user’s shopping cart.
Retrieve Shopping Cart Contents: Returns a list of books currently in the user's shopping cart.
Remove Book from Cart: Removes a specified book from the user’s shopping cart.

  

**Book Details**

Create Book: Allows an administrator to add a new book to the system.
Retrieve Book Details: Fetches details of a book by its ISBN.
Create Author: Enables an administrator to add a new author to the system.
Retrieve Books by Author: Returns a list of books associated with a specific author.

  

**Book Rating and Commenting**

- Create Book Rating: Allows users to rate a book on a 5-star scale.
- Create Book Comment: Enables users to leave comments on books.
- Retrieve Book Comments: Fetches all comments for a specific book.
- Retrieve Average Book Rating: Calculates and returns the average rating of a book.

  

**Wish List Management**

- Create Wishlist: Allows users to create a wishlist with a unique name.
- Add Book to Wishlist: Adds a book to a user’s wishlist.
- Remove Book from Wishlist: Removes a book from a user’s wishlist and optionally adds it to the shopping cart.
- List Books in Wishlist: Returns a list of books in a specific wishlist.

  

**Technologies Used**

- **Java**: Primary programming language for the backend.
- **Spring Boot**: Framework for building the API.
- **MongoDB**: NoSQL database for storing data.

**

# How to Run Program

**
1. Go to https://start.spring.io to initialize SpringBoot project. Select the following options and click "GENERATE" once finished.
- Project: Maven
- Language: Java
- Spring Boot: Default value
- Project Metadata: Group = com.group_3, Artifact = restful_group_3_project. Package name = com.group_3.restful_group_3_project
- Packaging: Jar
- Java: Default value (make sure java version is installed on your computer)
- Dependencies: Lombok, Spring Data MongoDB, Spring Web, Spring Dev Tools (Optional). 
2. Extract downloaded initialized project to secure folder and open it in your preferred IDE. Place all files from this repository into **restful_group_3_project/src/main/java/com/group_3/restful_group_3_project**

3. Sign up or log in to MongoDB (www.mongodb.com) and create a new project. Create a new Cluster in that project and choose to connect with MongoDB Compass. If you need to, download MongoDB Compass. Once done,  connect to the Cluster using your URI string, and create a new database within it; remember the name of it.
 
4. Get the URI string from your MongoDB cluster (looks like mongodb+srv://....) and in **src/main/resources/application.properties** copy and paste the following; make sure to replace the respective values with yours given by MongoDB:
#
    spring.application.name=restful_group_3_project
    spring.data.mongodb.database=nameOfYourDatabaseHere
    spring.data.mongodb.uri=placeYourURIHere
#
5. Inside your database, make sure to create two new collections, one titled "books", the other "users". If you wish, use the dummyDataFolder to import JSON data to those respective collections.

6. If you did steps 1-5, you should have a functioning project that's connected to MongoDB. Run it by running the file RestfulGroup3ProjectApplication.java in **restful_group_3_project/src/main/java/com/group_3/restful_group_3_project**


**License**

This project is licensed under the MIT License - see the LICENSE file for details.

  

**Authors**

- Janaii Eugene
- Fatasha Edwards
- Lathalia Faison
- Alejandra Dutton
- Miguel Adrian Gomez
- Christian Gonzalez

