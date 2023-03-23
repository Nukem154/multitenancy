# Multitenancy

This is a REST API with a multitenant architecture, where each tenant has its own database schema. The API uses JWT authorization, where the token is encoded with an RSA key.

## Technologies

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Security
- JWT
- MySQL
- Flyway
- C3p0

## Features

- Supports multitenancy, where each tenant has its own database schema.
- Uses JWT authorization, where the token is encoded with an RSA key.
- Allows tenants to sign up and create their own accounts.
- Provides REST endpoints for CRUD operations on tenant data.
- Provides REST endpoints for user authentication and authorization.
