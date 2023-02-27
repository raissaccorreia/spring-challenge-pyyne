# Spring Boot Code Challenge

## A REST WEB App that serves two unrelated functionalities

1) In-Memory stack
2) In-Memory key-value store with TTL (Time To Live)

## 📝 Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Built Using](#built_using)

## 🧐 About <a name = "about"></a>
I implemented the project matching a PDF with requirement, focusing in the functionality and syntax, so it's a simple version
without JSON response neither HTTP status code.

### General

#### Design

The application implements a simple MVC architecture, with a controller acting as view, a service, and a model one for each functionality.

#### Exception Handler

Try - Catch statements were used to handle exceptions at the controller methods aiming debug as the Java standard suggests.
If - Else statements were used to handle exceptions at the service methods aiming to provide user feedback about him or her inputs.

### Stack

Implemented from scratch using a linked list and pointers, in Java a object reference.

### In-memory key-value storage with TTL

- Key-Value storage was implemented using a Concurrent Hash Map
- For TTL the Value field was used to store not only the content, but also an integer that holds the amount of time in seconds that the content will be available, or zero if it's
permanent, and also the timestamp of creation of that object.
- By comparing the timestamp with timestamp + ttl we know if the object is valid yet and should be excluded or not.
- The data is only excluded through request or by attempting to get the data.

## 🏁 Getting Started <a name = "getting_started"></a>

After cloning the repository, you can run the application using the following command:

```bash
git clone https://github.com/raissaccorreia/spring-challenge-pyyne
cd ./spring-challenge-pyyne
mvn spring-boot:run
```

For that it's necessary to install the following requisites.

### Prerequisites

- Java openjdk version "17.0.2"
- Apache Maven 3.6.3

I run and developed the application on Ubuntu 22.04.2 LTS, here are the links to check for your OS.

[JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

[Maven](https://maven.apache.org/)

```bash
apt install openjdk-17-jdk openjdk-17-jre
unzip apache-maven-3.6.3-bin.zip
tar xzvf apache-maven-3.6.3-bin.tar.gz
```

### Running

## 🔧 Running the tests <a name = "tests"></a>

To run all the tests just run the following command:

```bash
mvn test
```

To run tests from a specific class, just run the following command:

"LifoTests" are for the stack functionality
"DictTests" are for the key-value storage functionality

```bash
mvn test -Dtest=LifoTests
mvn test -Dtest=DictTests
```

The tests are implemented using JUnit 5, and are focused on the service layer instead of controller.
Because they're unit tests, controller tests are supposed to be integration tests.

## 🎈 Usage <a name="usage"></a>

To make it more simple I added the Postman JSON export on the root of the project, with the name
"Hiring-Test-Spring.postman_collection.json"

### Stack

- Add to stack, the following add "hello" to the stack: http://localhost:8080/lifo?word="hello"

- Get from stack and also remove it: http://localhost:8080/lifo?word="hello"

#### Expected Returns for Stack

- Get from stack:
  - "Stack is empty" if stack is empty
  - "Value" if "Value" is found and removed from stack
  - "Error: Error Message" if an error occurs and fall into catch statement in controller

- Add from stack:
  - "Value" if "Value" is added to stack
  - "Error: Erro Message" if an error occurs and fall into catch statement in controller

### Key-Value Storage

- Add to storage, "name" as key and "larry" as value without TTL: http://localhost:8080/dict?key="name"&value="larry"
- Add to storage, "name" as key and "larry" as value with TTL of 10 seconds: http://localhost:8080/dict?key="name"&value="larry"&ttl=10
- Get from storage the value that has "name" as key: http://localhost:8080/dict?key="name"
- Remove from storage the value that has "name" as key: http://localhost:8080/dict?word="name"

#### Expected Returns for Key-Value

- Add to storage:
  - "Added: key = value without ttl" if "key, value" pair is added to storage without TTL
  - "Added: key = value with ttl seconds" if "key, value" pair is added to storage with TTL amount of seconds
  - "Error: Error Message" if an error occurs and fall into catch statement in controller

- Get from storage:
  - "Value" if "Value" is added to storage
  - "Word: value not found" if value is not found
  - "Error: Erro Message" if an error occurs and fall into catch statement in controller

- Delete from storage:
  - "Removed: value" if "value" is removed from storage successfully
  - "Fail to Remove: value" if "value" is not found
  - "Error: Erro Message" if an error occurs and fall into catch statement in controller

## ⛏️ Built Using <a name = "built_using"></a>

- [Postman](https://www.postman.com/)
- [Java 17](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
- [Spring Boot 3.0.2](https://spring.io/projects/spring-boot)
- [JUnit 5.8.1](https://junit.org/junit5/)
- [Maven 3.6.3](https://maven.apache.org/guides/index.html)
