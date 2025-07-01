# Intelli-Twin Backend
Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API for IntelliTower Management System

## Overview
This project provides a RESTful API for managing IntelliTower entities with the following features:
- Create, Read, Update, Delete (CRUD) operations for towers
- PostgreSQL database integration
- JPA/Hibernate for ORM
- Input validation
- Global exception handling

## API Endpoints
- `GET /api/v1/towers` - Get all towers
- `GET /api/v1/towers/{id}` - Get tower by ID
- `POST /api/v1/towers` - Create new tower
- `PUT /api/v1/towers/{id}` - Update existing tower
- `DELETE /api/v1/towers/{id}` - Delete tower

## Tower Properties
- `towerName` (required) - Name of the tower
- `location` (required) - Location of the tower
- `status` (required) - Current status (Active, Inactive, etc.)
- `height` (required) - Height of the tower
- `description` (optional) - Additional description

## Technologies Used
- Spring Boot 2.7.18
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven
