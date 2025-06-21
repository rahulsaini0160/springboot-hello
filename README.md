# Hello World Spring Boot Application

## Prerequisites

Before running this application, make sure you have installed:

- **Java JDK 17**  
  Download from [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/downloads/).
- **Apache Maven**  
  Download from [Maven Downloads](https://maven.apache.org/download.cgi).

To check if they are installed, run:
```sh
java -version
mvn -version
```

## How to Run the Application

1. **Clone or download the project.**
2. **Open a terminal in the project root (where `pom.xml` is located).**
3. **Run the following command to start the application:**
   ```sh
   mvn spring-boot:run
   ```
   The application will start on [http://localhost:8080](http://localhost:8080).

## API Endpoints

- `GET /hello?name=YourName`  
  Returns: `Hello YourName!`

- `GET /health`  
  Returns: `Application is running!`

## Running Tests

To run the test cases, use:
```sh
mvn test
```
Test classes are located in the `src/test/java/com/example/helloworld/` directory:
- `HelloWorldControllerTest.java` – tests the API endpoints.
- `HelloWorldApplicationTest.java` – tests application startup.


## Creating a JAR File

To build the application and create a JAR file, use:
```sh
mvn package
```
The JAR file will be generated in the `target/` directory.

- A JAR file (Java ARchive) is important because it packages all your compiled Java classes, resources, and dependencies into a single file. This makes it easy to distribute, deploy, and run your application on any system with Java installed. For Spring Boot projects, the JAR file is often "executable," meaning you can start your entire application with a simple command:

```sh
java -jar target/your-app-name.jar
```


## Summary

- Install Java JDK 17 and Maven.
- Run `mvn spring-boot:run` to start the app.
- Use the provided endpoints to interact with the app.
- Run `mvn test` to execute test cases.
- Run `mvn package` to create a JAR file in the `target/` folder.