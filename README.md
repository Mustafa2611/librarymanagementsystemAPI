# Library Management System

A simple Library Management System API built using Spring Boot.

## Description

This project provides a RESTful API for managing books, patrons, and borrowing records in a library system.
It allows librarians to perform CRUD operations on books and patrons, and record borrowing and return transactions.

## Requirements

- Java 11 or higher
- Maven
- MySQL (or any other supported database)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Mustafa2611/librarymanagementsystemAPI.git
    ```

2. Navigate to the project directory:

    ```bash
    cd librarymanagementsystemAPI
    ```

3. Set up MySQL database:
   
   - Create a new MySQL database.
   - Update the `application.properties` file with your database credentials.
   - Run the `schema.sql` script to create the required tables.
   - Optionally, you can populate the database with initial data using the `data.sql` script.

4. Build the project:

    ```bash
    mvn clean package
    ```

5. Run the application:

    ```bash
    java -jar target/librarymanagementsystemAPI-1.0-SNAPSHOT.jar
    ```

## API Endpoints

- **Book management endpoints**:
    - `GET /api/books`: Retrieve a list of all books.
    - `GET /api/books/{id}`: Retrieve details of a specific book by ID.
    - `POST /api/books`: Add a new book to the library.
    - `PUT /api/books/{id}`: Update an existing book's information.
    - `DELETE /api/books/{id}`: Remove a book from the library.

- **Patron management endpoints**:
    - `GET /api/patrons`: Retrieve a list of all patrons.
    - `GET /api/patrons/{id}`: Retrieve details of a specific patron by ID.
    - `POST /api/patrons`: Add a new patron to the system.
    - `PUT /api/patrons/{id}`: Update an existing patron's information.
    - `DELETE /api/patrons/{id}`: Remove a patron from the system.

- **Borrowing endpoints**:
    - `POST /api/borrow/{bookId}/patron/{patronId}`: Allow a patron to borrow a book.
    - `PUT /api/return/{bookId}/patron/{patronId}`: Record the return of a borrowed book by a patron.

## Documentation

For detailed documentation on how to interact with the API endpoints, refer to the [API documentation](docs/api.md).

## Contributing

Contributions are welcome! If you find any bugs or have suggestions for improvement, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
