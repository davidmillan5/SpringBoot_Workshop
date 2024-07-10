
# SpringBoot Workshop

This repository contains the source code for the SpringBoot Workshop, a project designed to demonstrate the basics of building web applications using Spring Boot. The workshop includes examples of various Spring Boot features and integrations, including a MySQL database setup using Docker.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Installation

To get started with the project, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/davidmillan5/SpringBoot_Workshop.git
   cd SpringBoot_Workshop
   ```

2. Ensure you have Java 8 or higher installed. You can check your Java version with:
   ```bash
   java -version
   ```

3. Ensure you have Gradle installed. You can check your Gradle version with:
   ```bash
   gradle -v
   ```

4. Ensure you have Docker installed. You can check your Docker version with:
   ```bash
   docker --version
   ```

## Configuration

The application uses a MySQL database. To set up the MySQL database, use Docker:

```bash
docker run --name mysql -e MYSQL_ROOT_PASSWORD=mysql12345678 -p 3308:3306/tcp mysql:latest
```

Update the `src/main/resources/application.properties` file with your database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3308/<DB_NAME>
spring.datasource.username=root
spring.datasource.password=mysql12345678
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
```

Replace `<DB_NAME>` with your MySQL database name.

## Running the Application

To run the application, use the following command:

```bash
gradle bootRun
```

The application will start on `http://localhost:8080`.

## Usage

Once the application is running, you can interact with it using the provided endpoints. Detailed information about the available endpoints and their usage can be found in the project's documentation.

## Contributing

Contributions are welcome! To contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch with your feature or bug fix:
   ```bash
   git checkout -b feature-branch
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-branch
   ```
5. Create a Pull Request.

## Swagger

```

http://localhost:8080/swagger-ui.html

```



## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
