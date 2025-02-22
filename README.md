# Shop Ease
This project is a basic e-commerce application built using Spring Boot. It includes essential functionalities such as order management, product management, user management, and admin operations. The application is designed with a structured architecture, including controllers, services, repositories, and Thymeleaf templates for the frontend. 

## Features
1. User Management (Registration, Login, Authentication & Authorization)
2. Product Management (CRUD operations for products)
3. Order Placement (Placing, viewing, and managing orders)
4. Admin Functionality (User & product management, order tracking)
5. PostgreSQL Database Integration
6. Data Validation & Error Handling
7. Thymeleaf-based UI with Bootstrap for Styling

## Tech Stack
1. Spring Boot (Core framework) 
2. Spring Web (RESTful web services)
3. Spring Data JPA (Database interaction)
4. PostgreSQL (Relational database)
5. Spring Security (User authentication & authorization)
6. Thymeleaf (Server-side template engine)
7. Spring Dev Tools (For development convenience)
8. Validation (Form and data validation)
9. Bootstrap (For frontend styling and responsive UI)

## Project Structure

├── src/main/java/com/example/ecommerce  <br/>
│   ├── controllers             &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;     *# Handles HTTP requests* <br/>
│   ├── entities            &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;      &nbsp;  &nbsp; *# Represents database tables* <br/>
│   ├── repositories         &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;        *# Handles database operations* <br/>
│   ├── services              &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;       *# Contains business logic* <br/>
│   └── EcommerceApplication.java&nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;    *# Main entry point* <br/>
├── src/main/resources/templates   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;  *# Thymeleaf HTML templates* <br/>
├── src/main/resources/static     &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   *# CSS, JS, Images* <br/>
├── src/main/resources/application.properties &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp;   &nbsp; &nbsp; *# Database config* <br/>
└── pom.xml &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp;&nbsp;  &nbsp; &nbsp;   &nbsp; &nbsp; *# Maven dependencies* <br/>

## Step & Installation
### Prerequisites
- Java 17+
- Maven
- PostgreSQL

### Steps
1. Clone the repository: <br/>
   `git clone https://github.com/yourusername/ecommerce-springboot.git` <br/>
    `cd ecommerce-springboot`
2. Configure PostgreSQL database in src/main/resources/application.properties: <br/>
   `spring.datasource.url=jdbc:postgresql://localhost:5432/shopease` <br/>
`spring.datasource.username=your_db_username` <br/>
`spring.datasource.password=your_db_password`
3. Run the application:
   `mvn spring-boot:run`
4. Open a browser and access:
   `http://localhost:8080`

## CRUD Operations
**Users**
- Register & Login
- View profile & edit details

**Products**
- Add new products (Admin)
- Update & delete products (Admin)
- View available products (All users)

**Orders**
- Place an order
- View order history
- Manage orders (Admin)

**Frontend**
- Uses Thymeleaf for rendering dynamic content.
- Bootstrap for a responsive UI.
- Templates include:
    - Homepage
    - Product Listing
    - Login/Register Pages
    - Admin Dashboard

## Security
1. Implements Spring Security for user authentication.
2. Supports role-based access (User/Admin).

## License
This project is licensed under the MIT License.
