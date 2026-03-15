# 🛒 DSCommerce - E-commerce Backend API

DSCommerce is a **RESTful backend application built with Java and Spring Boot** that simulates an e-commerce platform.

The system manages **products, categories, users, and orders**, demonstrating concepts such as **domain modeling, layered architecture, REST API design, and database persistence using JPA/Hibernate**.

This project was developed for learning purposes and to practice **modern backend development with Java and Spring Boot**.

---

# 🚀 Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- REST API
- Postman / Insomnia (API testing)

---

# 📂 Project Architecture

The project follows a **layered architecture**, which separates responsibilities and improves maintainability.

```
src
 └── main
     └── java
         └── com.dscommerce
             ├── controllers
             ├── services
             ├── repositories
             ├── entities
             ├── dto
             └── config
```

### Layers Overview

**Controller**
- Handles HTTP requests
- Defines API endpoints

**Service**
- Contains business logic
- Processes application rules

**Repository**
- Responsible for database access
- Uses Spring Data JPA

**Entities**
- Represent domain objects and database tables

**DTO (Data Transfer Objects)**
- Used to transfer data between layers and control API responses

**Config**
- Application configuration classes

---

# 🗄️ Domain Model

The system models a simplified **e-commerce platform** with the following entities:

### User
Represents a system user.

Fields example:
- id
- name
- email
- password
- roles

---

### Product
Represents a product available in the store.

Fields example:
- id
- name
- description
- price
- imageUrl

---

### Category
Represents product categories.

Fields example:
- id
- name

---

### Order
Represents a purchase made by a user.

Fields example:
- id
- moment
- status
- client

---

### OrderItem
Represents items inside an order.

Fields example:
- product
- quantity
- price

---

### Payment
Represents the payment associated with an order.

Fields example:
- id
- moment

---

# 📡 API Endpoints

## Get all products

```
GET /products
```

---

## Get product by ID

```
GET /products/{id}
```

---

## Get all categories

```
GET /categories
```

---

## Get orders

```
GET /orders
```

---

## Create order

```
POST /orders
```

Example request body:

```json
{
  "userId": 1,
  "items": [
    {
      "productId": 3,
      "quantity": 2
    }
  ]
}
```

---

# ▶️ Running the Project

## 1. Clone the repository

```bash
git clone https://github.com/MarceloDebug/dscommerce.git
```

## 2. Enter the project folder

```bash
cd dscommerce
```

## 3. Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

# 🔎 Testing the API

You can test the API using tools such as:

- Postman
- Insomnia
- cURL
- Browser (for GET endpoints)

Example:

```
http://localhost:8080/products
```

---

# 🧠 Concepts Applied

This project demonstrates several backend development concepts:

- REST API design
- Layered architecture
- Domain modeling
- DTO pattern
- Dependency injection
- Database persistence with JPA/Hibernate
- Entity relationships
- Clean code organization

---

# 📌 Project Purpose

The goal of this project is to practice **Java backend development using Spring Boot** while implementing a real-world **e-commerce API structure**.

It also serves as part of a **software development portfolio**, demonstrating backend development skills and knowledge of modern Java technologies.

---

# 👨‍💻 Author

**Marcelo Soares**

GitHub:  
https://github.com/MarceloDebug
