# 🐾 Pet Store Application

A Spring Boot web application that simulates a pet store, allowing users to buy pets based on their budget.

## 📦 Features

- Users and pets are stored in a relational database.
- Each user has a budget; each pet has a calculated price (based on age and rating).
- Users can "buy" pets if they can afford them.
- Purchase history is stored (if enabled).
- REST API available for listing, buying, and creating users/pets.

## 🚀 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 (in-memory) database (default for testing)
- Maven
- ✅ Includes unit and integration tests to verify business logic (e.g., pet purchase, price calculation).
- 📮 Tested with Postman to ensure API endpoints work as expected.
-
 ## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Matea111777/PetStoreApp.git
cd PetStoreApp

### 2.  Run the Application
  ./mvnw spring-boot:run
### 3. API Endpoints
Create Users
-POST /users/create-users
Create Pets
-POST /pets/create-pets
List All Users
-GET /users/list-users
List All Pets
-GET /pets/list-pets
Buy Pets (match users with affordable pets)
-POST /pets/buy-pets
Purchase History (placeholder)
-GET /pets/history

✅ Run Tests
To execute unit and integration tests:
./mvnw test
📬 Author
blazeskamatea17@gmail.com


