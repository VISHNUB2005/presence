# Presence – Digital Presence Management System

Presence is a Spring Boot based backend system designed to manage and analyze digital presence data for marketing-driven organizations.  
It centralizes user engagement, attendance, and interaction data into a structured and scalable backend architecture.

---

## 📌 Problem Statement

Marketing organizations rely heavily on customer engagement and feedback.  
However, managing digital presence data across multiple tools leads to inconsistency, inefficiency, and data fragmentation.

Presence solves this problem by providing a centralized REST-based backend system for structured data management and future scalability.

---

## 🚀 Solution Overview

Presence provides:

- User Management APIs
- Attendance / Presence Tracking APIs
- RESTful backend architecture
- Structured database storage using MySQL
- Layered architecture (Controller → Service → Repository)
- JSON-based API responses

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Gradle
- REST APIs
- Ngrok (for external API testing)
- Postman (API Testing)

---

## 🏗 Architecture

Client → REST Controller → Service Layer → Repository Layer → MySQL Database

### Layer Explanation:

- **Controller Layer** – Handles incoming HTTP requests  
- **Service Layer** – Contains business logic  
- **Repository Layer** – Communicates with database using JPA  
- **Database Layer** – MySQL for persistent storage  

---

## ✅ Features Implemented

- Create User
- Fetch All Users
- Update User
- Delete User
- Attendance / Presence Entity
- Structured JSON API responses
- Database integration using JPA

---

## 🔗 API Endpoints

### User APIs

- `POST /users`
- `GET /users`
- `PUT /users/{id}`
- `DELETE /users/{id}`

### Presence APIs

- `POST /presence`
- `GET /presence`

---

## ⚙️ Setup Instructions

1. Clone the repository

   ```bash
   git clone [https://github.com/VISHNUB2005/presence]
   ```

2. Configure MySQL database

3. Update `application.properties` with your database credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/presence_db
   spring.datasource.username=root
   spring.datasource.password=root
   ```

4. Run the project:

   ```bash
   ./gradlew bootRun
   ```

5. Access APIs at:

   ```
   http://localhost:8080
   ```

---

## 🔮 Future Enhancements

- Frontend Dashboard Integration
- JWT Authentication
- Role-Based Access Control
- Analytics & Reporting Dashboard
- Cloud Deployment (AWS)
- Workflow Automation using n8n
- AI-based Engagement Insights

---

## 👨‍💻 Author

Vishnu B  
Computer Science Engineering Student  
Backend & System Architecture Enthusiast  

---

## 📄 License

This project is developed for learning and demonstration purposes.
