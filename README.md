# Getting Started

# Bootiful Aggregated Book Service

## Introduction

Bootiful Aggregated Book Service is a Spring Boot application that demonstrates the aggregation of paginated results from two different tables, `BookA` and `BookB`. The application provides a single endpoint to fetch combined paginated results from both tables, ensuring consistent and accurate pagination.

## Features

- Aggregates data from two separate tables within the same application.
- Supports pagination to display a specified number of records per page.
- Ensures efficient data fetching and aggregation.
- Simplifies the aggregation logic by using dynamic offsets.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Setup

### Prerequisites

- Java 21 or higher
- Gradle
- H2 (or any other relational database)

### Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/anishpanthi/bootiful-aggregator.git
    cd bootiful-aggregator
    ```

2. **Configure the database**:

   This application uses H2 In-Memory database, so you can leave the database configuration as it is in the `application.yml` file
   If you want to use your own database like PostgreSQL, you can configure it in the `application.yml` file: 

    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/your-database
        username: your-username
        password: your-password
        driver-class-name: org.postgresql.Driver
        initialization-mode: always
      jpa:
        hibernate:
          ddl-auto: update
        defer-datasource-initialization: true
    ```
   
   Ensure that `schema.sql` and `data.sql` are placed in the `src/main/resources` directory. Sample is provided in the repository.


3. **Build the application**:

    ```bash
    ./gradlew build
    ```

4. **Run the application**:

    ```bash
    ./gradlew bootRun
    ```

## Usage

Once the application is running, you can access the aggregated books endpoint to fetch paginated results.

### Example Request

To fetch the first page with 5 records:

```http
GET http://localhost:8080/aggregator/api/books?page=0&size=5
```

```json
{
  "content": [
    {
      "id": 1,
      "title": "Book A1",
      "source": "A"
    },
    {
      "id": 1,
      "title": "Book B1",
      "source": "B"
    },
    {
      "id": 2,
      "title": "Book A2",
      "source": "A"
    },
    {
      "id": 2,
      "title": "Book B2",
      "source": "B"
    },
    {
      "id": 3,
      "title": "Book A3",
      "source": "A"
    }
  ],
  "page": {
    "size": 5,
    "number": 0,
    "totalElements": 10,
    "totalPages": 2
  }
}
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.1/gradle-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#actuator)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.1/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

