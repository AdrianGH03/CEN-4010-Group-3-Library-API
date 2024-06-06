Geek Text - Online Bookstore API
Project Overview
Geek Text is an online bookstore API designed to support an application targeting a niche in technology books. This API allows users to browse and sort books, manage their profiles, handle shopping cart operations, view book details, rate and comment on books, and manage wishlists.

Features
Book Browsing and Sorting
Retrieve List of Books by Genre: Allows users to get a list of books within a specific genre.
Retrieve List of Top Sellers: Returns the top 10 books that have sold the most copies.
Retrieve List of Books by Rating: Filters and returns books with a rating equal to or higher than a specified value.
Discount Books by Publisher: Updates the price of all books from a particular publisher by a specified discount percentage.

Profile Management
Create a User: Enables users to create a profile with a username, password, and optional personal information.
Retrieve User Profile: Allows users to fetch their profile information using their username.
Update User Profile: Lets users update their profile information except for their email address.
Create Credit Card for User: Associates a credit card with the user's profile.

Shopping Cart
Retrieve Subtotal: Provides the subtotal price of all items in a user’s shopping cart.
Add Book to Cart: Adds a book to the user’s shopping cart.
Retrieve Shopping Cart Contents: Returns a list of books currently in the user's shopping cart.
Remove Book from Cart: Removes a specified book from the user’s shopping cart.

Book Details
Create Book: Allows an administrator to add a new book to the system.
Retrieve Book Details: Fetches details of a book by its ISBN.
Create Author: Enables an administrator to add a new author to the system.
Retrieve Books by Author: Returns a list of books associated with a specific author.

Book Rating and Commenting
Create Book Rating: Allows users to rate a book on a 5-star scale.
Create Book Comment: Enables users to leave comments on books.
Retrieve Book Comments: Fetches all comments for a specific book.
Retrieve Average Book Rating: Calculates and returns the average rating of a book.

Wish List Management
Create Wishlist: Allows users to create a wishlist with a unique name.
Add Book to Wishlist: Adds a book to a user’s wishlist.
Remove Book from Wishlist: Removes a book from a user’s wishlist and optionally adds it to the shopping cart.
List Books in Wishlist: Returns a list of books in a specific wishlist.

Technologies Used
Java: Primary programming language for the backend.
Spring Boot: Framework for building the API.
MongoDB: NoSQL database for storing data.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Authors
-Janaii
-Fatasha Edwards
-Lathalia Faison
-Alejandra
-Miguel
-Christian Gonzalez 
