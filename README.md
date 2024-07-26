# Task Management App
This Spring Boot application provides a REST API for task management.


## Prerequisites
- Java
- MySQL


## Installation
git clone https://github.com/your-user/Task_Backend.git

## Database Configuration
Modify the database settings in the src/main/resources/application.properties file. Make sure to set the correct URL, username, and password for your MySQL database.


## Running the Application
Run the Spring Boot application using your IDE or via the command line: 
./mvnw spring-boot:run.
The application will be accessible at http://localhost:8080.

 ## Using the API
 The API exposes endpoints to perform CRUD operations on tasks. Here are some examples:

- GET http://localhost:8080/api/v1/task: Retrieve all tasks.
- POST http://localhost:8080/api/v1/task/saveTask: Save a new task.
- DELETE http://localhost:8080/api/v1/task/{taskId}: Delete a task with the specified ID.
- PUT http://localhost:8080/api/v1/task/{taskId}: Update a task with the specified ID.

  ## Authentication with Spring Security
  The application utilizes Spring Security to manage authentication. Login and signup functionalities are available.
 
