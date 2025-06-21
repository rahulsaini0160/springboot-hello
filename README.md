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

# CI/CD with GitHub Actions

This project uses **GitHub Actions** to automate testing, running, and building your Spring Boot application. The workflow file is located at `.github/workflows/ci-cd.yml`.

---

### When does the workflow run?

- **On every push** to the `main` or `develop` branches.
- **On every pull request** to the `main` branch.

---

### What does the workflow do?

The workflow is divided into three jobs (stages):

#### 1. **Test**
- **Runs on:** Ubuntu Linux.
- **What it does:**
  - Checks out your code from GitHub.
  - Sets up Java 17 (required for Spring Boot).
  - Caches Maven dependencies to speed up builds.
  - Runs all tests using Maven (`mvn clean test`).
- **Purpose:** Ensures your code is correct and all tests pass before moving to the next steps.

#### 2. **Run**
- **Runs on:** Ubuntu Linux.
- **Depends on:** The `test` job (only runs if tests pass).
- **What it does:**
  - Checks out your code and sets up Java 17 (again, each job is isolated).
  - Caches Maven dependencies.
  - Starts your Spring Boot application in the background (`mvn spring-boot:run &`).
  - Waits 20 seconds to let the app start.
  - Checks if the app is running by calling the `/health` endpoint.
- **Purpose:** Verifies that your application can start successfully and is healthy.

#### 3. **Build**
- **Runs on:** Ubuntu Linux.
- **Depends on:** The `run` job (only runs if the app started successfully).
- **What it does:**
  - Checks out your code and sets up Java 17.
  - Caches Maven dependencies.
  - Packages your application into a JAR file (`mvn package -DskipTests`).
  - Uploads the JAR file as an artifact so you can download it from the workflow run.
- **Purpose:** Creates a distributable JAR file if all previous steps succeed.

---

### Why is this useful?

- **Automates testing and building** every time you push code or open a pull request.
- **Ensures your app works** before you deploy or share it.
- **Provides downloadable build artifacts** (the JAR file) from each workflow run.
- **No manual steps needed**—GitHub Actions does everything for you!

---

### Summary of Workflow Steps

1. **Test:** Make sure your code is correct.
2. **Run:** Make sure your app starts and is healthy.
3. **Build:** Package your app into a JAR file for deployment or sharing.

You can find the workflow file at `.github/workflows/ci-cd.yml` in this repository.
