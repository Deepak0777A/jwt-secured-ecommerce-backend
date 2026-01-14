# 🛒 JWT Secured E-commerce Backend (Spring Boot)

A secure and scalable E-commerce backend application built using **Spring Boot**, implementing **JWT authentication**, **role-based authorization**, and clean layered architecture.  
The application exposes RESTful APIs for managing products, categories, and orders, tested using **Postman**.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- JWT-based login and registration
- Role-based access control (ADMIN / USER)
- Stateless security using Spring Security

### 🧑‍💼 Admin Features
- Create product categories
- Add products (ADMIN only)
- Delete only products created by the same admin
- Product creation tracking (createdBy, createdAt)

### 🛍 User Features
- View available products
- Place orders
- View own order history

### 📦 Order Management
- Order & OrderItem separation
- Price preserved at purchase time
- Stock validation during checkout

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

---

## 🏗 Project Architecture

controller → handles HTTP requests
service → business logic
repository → database access
entity → JPA entities
dto → request/response models
mapper → DTO ↔ Entity conversion
security → JWT & Spring Security
exception → global exception handling

yaml
Copy code

---

## 🔐 Roles & Access Rules

| Endpoint | Role |
|-------|------|
| /admin/** | ADMIN |
| /products | USER / ADMIN |
| /user/orders | USER |

---

## 📂 Main Modules

- Authentication (JWT)
- Category
- Product
- Order & OrderItem

---

## 🧪 API Testing (Postman)

All APIs are tested using **Postman** with JWT Bearer Token authentication.

### Sample Flow
1. Register ADMIN / USER
2. Login and receive JWT token
3. ADMIN creates categories & products
4. USER views products
5. USER places orders
6. USER fetches order history

---

## 📌 Sample JWT Header

Authorization: Bearer <JWT_TOKEN>

yaml
Copy code

---

## 🗄 Database Design (Simplified)

- users
- categories
- products
- orders
- order_items

---

## 🧠 Key Design Decisions

- DTOs used to avoid exposing entities
- Mapper layer for clean conversion
- JWT username used instead of direct User entity relation
- Ownership validation handled in service layer
- Stateless authentication for scalability

---

## 📄 Resume Description

> Developed a JWT secured E-commerce backend application using Spring Boot with role-based authorization, product and order management, DTO mapping, and REST APIs tested via Postman.

---

## 🔮 Future Enhancements

- Pagination & sorting
- Global exception handler
- Cloud image upload (AWS S3 / Cloudinary)
- Payment gateway integration
- Order status tracking

---

## 👨‍💻 Author

Deepak  
Backend Java Developer | Spring Boot
