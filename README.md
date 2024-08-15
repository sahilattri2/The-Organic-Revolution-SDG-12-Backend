# Organic-Farming-Backend
This repository contains the backend code for the Organic Farming Web Application. The backend is developed using Spring Boot and provides the necessary RESTful APIs for handling user management, blog management, farm visit scheduling, image uploads, email notifications, and more. The database used is MySQL, ensuring robust and scalable data management.

## Features
User Management: Handles user registration, login, profile updates, and authentication.
Blog Management: Provides CRUD operations for blog posts, supporting multiple Indian languages.
Farm Visit Scheduling: Manages scheduling of farm visits, including viewing details and managing requests.
Image Management: Handles image uploads and retrievals for blogs and community posts.
Email Notifications: Sends email notifications to users and community members regarding scheduled visits and updates.
Text-to-Speech: Converts blog content to speech in four Indian languages.
Multi-Language Support: Manages blogs and other content in multiple Indian languages.
## Installation
To set up and run the backend server locally, follow these steps:

Clone the repository:

git clone https://github.com/sahilattri2/organic-farming-backend.git

  cd organic-farming-backend
## Install Dependencies:
./mvnw install
## Setup Database:
Create a MySQL database.
Update the database configurations in the src/main/resources/application.properties file.

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
## Run the Backend Server:

./mvnw spring-boot:run

## API Endpoints
Here’s a summary of the key API endpoints:

## User Management:

POST /api/users/register - Register a new user.
POST /api/users/login - Log in an existing user.
PUT /api/users/{id} - Update user profile.
## Blog Management:

GET /api/blogs - Get all blog posts.
POST /api/blogs - Create a new blog post.
PUT /api/blogs/{id} - Update an existing blog post.
DELETE /api/blogs/{id} - Delete a blog post.
## Farm Visit Scheduling:

GET /api/visits - View all scheduled visits.
POST /api/visits - Schedule a new farm visit.
## Image Management:

POST /api/images/upload - Upload an image.
GET /api/images/{filename} - Retrieve an image by filename.
## Email Notifications:

POST /api/notifications/send - Send an email notification.
## Text-to-Speech:

POST /api/text-to-speech - Convert text to speech in selected languages.
Contributing
Contributions are welcome! If you have suggestions for new features or improvements, feel free to fork the repository and create a pull request. You can also open an issue to discuss any changes.

## Fork the Project<br />
Create your Feature Branch (git checkout -b feature/NewFeature)<br />
Commit your Changes (git commit -m 'Add some NewFeature')<br />
Push to the Branch (git push origin feature/NewFeature)<br />

## Contact
NAME: SAHIL <br />
EMAIL: attri1379@gmail.com<br />
Project Portfolio: https://sites.google.com/view/sahilattri/organic-farming
