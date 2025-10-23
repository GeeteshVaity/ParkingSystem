# 🚗 Smart Parking System

A Java Swing desktop application for managing parking spots, backed by a MySQL database. This system enables users to register, log in, register their vehicles, book available parking spots, and check out.

---

## 📑 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## ✨ Features

- **User Authentication**: Secure sign-up and login for members.
- **Vehicle Registration**: Members can register their vehicle details.
- **Parking Spot Management**: Visual representation of parking lots (Lot A, Lot B) with individual spots.
- **Booking System**: Members can select an available spot and book it with a specified entry time.
- **Check-Out System**: Members can clear their booked spot by providing an exit time.
- **Real-time Updates (Conceptual)**: Tracks spot usage based on booking and check-out times.

---

## 🛠️ Technology Stack

| Component         | Details                          |
|------------------|----------------------------------|
| Language          | Java (JDK 17+)                   |
| GUI Framework     | Java Swing                       |
| Database          | MySQL                            |
| Build Tool        | Apache Maven                     |
| IDE               | IntelliJ IDEA                    |

---

## ✅ Prerequisites

Ensure the following are installed and configured:

- Java Development Kit (JDK) 17 or later
- Apache Maven
- MySQL Server (8.0+ recommended)
- MySQL Client (Workbench, DBeaver, or CLI)

---

## 🗄️ Database Setup

### 1. Create the Database

```sql
CREATE DATABASE Smart_Parking_System;
USE Smart_Parking_System;
```

### 2. Create Tables

```sql
-- Drop existing tables
DROP TABLE IF EXISTS ParkingTime;
DROP TABLE IF EXISTS Vehicle;
DROP TABLE IF EXISTS ParkingArea;
DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Parking;

-- Create new tables
CREATE TABLE Member (
    M_id INT PRIMARY KEY AUTO_INCREMENT,
    M_Fname VARCHAR(50) NOT NULL,
    M_Lname VARCHAR(50) NOT NULL,
    M_contactNo VARCHAR(15) NOT NULL,
    M_address VARCHAR(100),
    password INT NOT NULL
);

CREATE TABLE Parking (
    P_id INT PRIMARY KEY AUTO_INCREMENT,
    P_name VARCHAR(50) NOT NULL
);

CREATE TABLE ParkingArea (
    Slot_No INT PRIMARY KEY,
    P_block VARCHAR(10) NOT NULL,
    Date_time DATETIME,
    P_id INT,
    FOREIGN KEY (P_id) REFERENCES Parking(P_id)
);

CREATE TABLE Vehicle (
    V_regNo VARCHAR(20) PRIMARY KEY,
    V_engNo VARCHAR(30) NOT NULL,
    V_name VARCHAR(50),
    V_model VARCHAR(50),
    P_id INT,
    M_id INT,
    FOREIGN KEY (P_id) REFERENCES Parking(P_id),
    FOREIGN KEY (M_id) REFERENCES Member(M_id)
);

CREATE TABLE ParkingTime (
    Pt_id INT PRIMARY KEY AUTO_INCREMENT,
    M_id INT,
    V_regNo VARCHAR(20),
    Slot_No INT,
    InTime DATETIME NOT NULL,
    OutTime DATETIME,
    FOREIGN KEY (M_id) REFERENCES Member(M_id),
    FOREIGN KEY (V_regNo) REFERENCES Vehicle(V_regNo),
    FOREIGN KEY (Slot_No) REFERENCES ParkingArea(Slot_No)
);
```

### 3. Populate Initial Data

```sql
INSERT INTO Parking (P_id, P_name)
VALUES (1, 'Lot A'), (2, 'Lot B');

INSERT INTO ParkingArea (Slot_No, P_block, Date_time, P_id)
VALUES
(1, 'A', NOW(), 1), (2, 'A', NOW(), 1), (3, 'A', NOW(), 1), (4, 'A', NOW(), 1),
(5, 'A', NOW(), 1), (6, 'A', NOW(), 1), (7, 'A', NOW(), 1), (8, 'A', NOW(), 1),
(9, 'B', NOW(), 2), (10, 'B', NOW(), 2), (11, 'B', NOW(), 2), (12, 'B', NOW(), 2),
(13, 'B', NOW(), 2), (14, 'B', NOW(), 2), (15, 'B', NOW(), 2), (16, 'B', NOW(), 2);
```

---

## ⚙️ Configuration

Update your database credentials in:

`src/main/java/org/example/DatabaseConnection.java`

```java
public class DatabaseConnection {
    public static final String url = "jdbc:mysql://localhost:3306/Smart_Parking_System";
    public static final String username = "root";
    public static final String password = "password_here";
}
```

---

## ▶️ Running the Application

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd ParkingSystem
```

### 2. Compile with Maven

```bash
mvn clean compile
```

### 3. Run the Application

```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

> Note: Ensure `exec-maven-plugin` is added to your `pom.xml`.

### 4. Run from IDE

- Open the project in IntelliJ IDEA or VS Code.
- Ensure Maven dependencies are loaded.
- Locate `org.example.Main` and run `Main.main()`.

---

## 📁 Project Structure

```
ParkingSystem/
├── .idea/                  # IntelliJ project files
├── src/
│   ├── main/
│   │   ├── db/             # SQL schema files
│   │   ├── java/
│   │   │   ├── Data/       # Data models (Member, Vehicle, etc.)
│   │   │   ├── GUI/        # Swing GUI components
│   │   │   └── org/example/ # Main logic and DB connection
│   └── test/               # Unit tests (optional)
├── pom.xml                 # Maven configuration
└── README.md               # This file
```

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Make your changes.
4. Commit: `git commit -m 'Add some feature'`
5. Push: `git push origin feature/your-feature-name`
6. Open a Pull Request.

Please follow the existing code style and include relevant documentation.

---

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

