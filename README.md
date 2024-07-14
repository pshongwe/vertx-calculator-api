
# Vert.x Calculator API

This is a simple calculator API built using Eclipse Vert.x. It supports basic arithmetic operations: addition, subtraction, multiplication, and division.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Folder Structure](#folder-structure)
- [License](#license)

## Features

- Addition of two numbers
- Subtraction of two numbers
- Multiplication of two numbers
- Division of two numbers

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/vertx-calculator-api.git
   cd vertx-calculator-api
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Application

1. Package the application:
   ```bash
   mvn package
   ```

2. Run the application:
   ```bash
   java -cp target/vertx-calculator-api-1.0-SNAPSHOT.jar com.example.MainVerticle
   ```

3. The server will start on port 8888.

## API Endpoints

### Addition

- **URL:** `/add`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "num1": 5,
    "num2": 3
  }
  ```
- **Response:**
  ```json
  {
    "result": 8
  }
  ```

### Subtraction

- **URL:** `/subtract`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "num1": 5,
    "num2": 3
  }
  ```
- **Response:**
  ```json
  {
    "result": 2
  }
  ```

### Multiplication

- **URL:** `/multiply`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "num1": 5,
    "num2": 3
  }
  ```
- **Response:**
  ```json
  {
    "result": 15
  }
  ```

### Division

- **URL:** `/divide`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "num1": 6,
    "num2": 3
  }
  ```
- **Response:**
  ```json
  {
    "result": 2
  }
  ```

- **Error Response (when dividing by zero):**
  ```json
  {
    "error": "Cannot divide by zero"
  }
  ```

## Folder Structure

```
vertx-calculator-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── verticles/
│   │   │           │   └── CalculatorVerticle.java
│   │   │           ├── handlers/
│   │   │           │   ├── AddHandler.java
│   │   │           │   ├── SubtractHandler.java
│   │   │           │   ├── MultiplyHandler.java
│   │   │           │   └── DivideHandler.java
│   │   │           └── MainVerticle.java
│   │   ├── resources/
│   │   │   └── config/
│   │   │       └── config.json
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── CalculatorVerticleTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
