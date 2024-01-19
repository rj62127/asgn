# auth-service

- **Overview:** The auth-service is a Spring Boot application developed to offer robust authentication and user management capabilities. Leveraging the power of Spring Boot and several essential dependencies, this project provides a foundation for building secure and scalable authentication systems.

- **Key Features:**
  - User Signup: Allows users to register by providing necessary information such as name, email, and password.
  - User Login: Facilitates user authentication through a secure login process.
  - User Information Retrieval: Enables the retrieval of user details based on the provided email.
  - JWT Authentication: Implements JSON Web Token (JWT) authentication for secure and stateless communication.
  - Global Exception Handling: Enhances error responses through a global exception handler, ensuring a consistent and user-friendly experience in case of unexpected issues.
  - The password is encrypted during the signup process to protect user credentials.

## Project Dependencies

- **Spring Boot Starter Web**
- **Spring Boot Starter Data JPA**
- **H2 Database** (runtime scope for in-memory database)
- **Lombok** (optional, for reducing boilerplate code)
- **Spring Boot Starter Test** (for testing)
- **ModelMapper** (for object mapping)
- **Spring Boot Starter Validation** (for validation)
- **Spring Boot Starter Security** (for security features)
- **jjwt-api, jjwt-impl, jjwt-jackson** (for JWT authentication)

## Project Setup:
  1. Unzip the folder and go to the auth-service folder
  2. Open a terminal or command prompt.
  3. Navigate to the root directory of the project where the `pom.xml` file is located.
  4. Run the following Maven command to build the project:
     mvn clean install
  5.  Run the following Maven command to run the project:
     mvn spring-boot:run
   
  6. Access the localhost url at 9090: http://localhost:9090/

# Auth Endpoints: 

## User Signup
- **Endpoint:** `POST /users/signup`
- **Method:** `POST`
- **Functionality:** Registers a new user.
- **Request Body:** [SignupRequest](#signuprequest)
- **Example:** [http://localhost:9090/users/signup](http://localhost:9090/users/signup)

## User Login
- **Endpoint:** `POST /users/login`
- **Method:** `POST`
- **Functionality:** Authenticates a user.
- **Request Body:** [LoginRequest](#loginrequest)
- **Example:** [http://localhost:9090/users/login](http://localhost:9090/users/login)

## Secure endpoints: 

## Welcome Message:
- **Endpoint:** `GET /users/hello`
- **Method:** `GET`
- **Functionality:** Returns a welcome message.
- **Example:** [http://localhost:9090/users/hello](http://localhost:9090/users/hello)

## Get User by Email
- **Endpoint:** `GET /users`
- **Method:** `GET`
- **Functionality:** Retrieves user information by email.
- **Query Parameter:** `email`
- **Example:** [http://localhost:9090/users?email=test@example.com](http://localhost:9090/users?email=test@example.com)

# Request and Response Models

## SignupRequest
- **Description:** Request body for user signup.
- **Fields:**
  - `name` (String): User's name.
  - `email` (String): User's email.
  - `password` (String): User's password.

## LoginRequest
- **Description:** Request body for user login.
- **Fields:**
  - `email` (String): User's email.
  - `password` (String): User's password.

## SignupResponse
- **Description:** Response body for user signup.
- **Fields:**
  - `email` (String): User's email.
  - `message` (String): Signup message.

## AuthResponse
- **Description:** Response body for user authentication.
- **Fields:**
  - `token` (String): Authentication token.

## UserResponse
- **Description:** Response body for user information.
- **Fields:**
  - Include fields for user information like(name,email).

