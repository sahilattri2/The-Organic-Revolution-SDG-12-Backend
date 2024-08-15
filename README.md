# Organic-Farming-Backend
This repository contains the backend code for the Organic Farming Web Application. The backend is developed using Spring Boot and provides the necessary RESTful APIs for handling user management, blog management, farm visit scheduling, image uploads, email notifications, and more. The database used is MySQL, ensuring robust and scalable data management.

## Features
User Management: Handles user registration, login, profile updates, and authentication.<br /> 
Blog Management: Provides CRUD operations for blog posts, supporting multiple Indian languages.<br /> 
Farm Visit Scheduling: Manages scheduling of farm visits, including viewing details and managing requests.<br /> 
Image Management: Handles image uploads and retrievals for blogs and community posts.<br /> 
Email Notifications: Sends email notifications to users and community members regarding scheduled visits and updates.<br /> 
Text-to-Speech: Converts blog content to speech in four Indian languages.<br /> 
Multi-Language Support: Manages blogs and other content in multiple Indian languages.<br /> 
## Installation
To set up and run the backend server locally, follow these steps:

Clone the repository:

git clone https://github.com/sahilattri2/organic-farming-backend.git

  cd organic-farming-backend
## Install Dependencies:
./mvnw install
## Setup Database:
Create a MySQL database.<br /> 
Update the database configurations in the src/main/resources/application.properties file.

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name<br /> 
spring.datasource.username=your_username<br /> 
spring.datasource.password=your_password<br /> 
## Run the Backend Server:

./mvnw spring-boot:run

## API Endpoints
Here’s a summary of the key API endpoints:

## User Management:

POST /api/users/register - Register a new user.<br /> 
POST /api/users/login - Log in an existing user.<br /> 
PUT /api/users/{id} - Update user profile.<br /> 
## Blog Management:

GET /api/blogs - Get all blog posts.<br /> 
POST /api/blogs - Create a new blog post.<br /> 
PUT /api/blogs/{id} - Update an existing blog post.<br /> 
DELETE /api/blogs/{id} - Delete a blog post.<br /> 
## Farm Visit Scheduling:

GET /api/visits - View all scheduled visits.<br /> 
POST /api/visits - Schedule a new farm visit.<br /> 
## Image Management:

POST /api/images/upload - Upload an image.<br /> 
GET /api/images/{filename} - Retrieve an image by filename.<br /> 
## Email Notifications:

POST /api/notifications/send - Send an email notification.<br /> 
## Text-to-Speech:

POST /api/text-to-speech - Convert text to speech in selected languages.<br /> 
## Contributing
Contributions are welcome! If you have suggestions for new features or improvements, feel free to fork the repository and create a pull request. You can also open an issue to discuss any changes.

## Fork the Project<br />
Create your Feature Branch (git checkout -b feature/NewFeature)<br />
Commit your Changes (git commit -m 'Add some NewFeature')<br />
Push to the Branch (git push origin feature/NewFeature)<br />

## Contact
NAME: SAHIL <br />
EMAIL: attri1379@gmail.com<br />
Project Portfolio: https://sites.google.com/view/sahilattri/organic-farming
