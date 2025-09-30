# Aspectow To-Do Web Application

This is a sample "To-Do" web application built with Aspectow Enterprise Edition. It demonstrates how to create a simple, database-driven web application using Aspectran and its related technologies.

## About this Project

This project serves as a practical example for developers getting started with Aspectow. It includes basic CRUD (Create, Read, Update, Delete) operations for managing a to-do list, showcasing the core features of the Aspectran framework in a web environment.

## Key Technologies

- **Framework**: Aspectran
- **Web Server**: Undertow (embedded)
- **View Layer**: Thymeleaf
- **Database**: H2 (embedded)

## Requirements

- Java 21 or later
- Maven 3.6.3 or later

## Building from Source

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/aspectran/aspectow-todo-webapp.git
    ```

2.  **Navigate to the project directory:**
    ```sh
    cd aspectow-todo-webapp
    ```

3.  **Build the project with Maven:**
    This will compile the source code and package the application.
    ```sh
    mvn clean package
    ```

## Running the Application

Once the project is built, you can start the application using the Aspectran Shell.

1.  **Navigate to the `bin` directory:**
    ```sh
    cd app/bin
    ```

2.  **Start the Aspectran Shell:**
    ```sh
    ./shell.sh
    ```

3.  **Access the application:**
    Open your web browser and navigate to [http://localhost:8080](http://localhost:8080).

## License

This project is licensed under the [Apache License 2.0](LICENSE.txt).
