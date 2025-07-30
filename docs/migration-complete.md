# High School Management System - Java Migration

## Project Overview

This project has been successfully migrated from Python FastAPI to Java 21 with Spring Boot 3, following Clean Architecture principles.

## Technology Stack

- **Java 21** - Latest LTS version of Java
- **Spring Boot 3.3.6** - Modern Spring framework
- **Spring Data MongoDB** - Database integration
- **Spring Security** - Authentication and authorization
- **JUnit 5 (Jupiter)** - Unit testing framework
- **Mockito** - Mocking framework for tests
- **Jacoco** - Test coverage reporting
- **Maven** - Build and dependency management
- **PlantUML** - Architecture diagrams

## Architecture

The project follows Clean Architecture principles with the following layers:

### Domain Layer (`domain/`)
- **Entities**: Core business objects (`Activity`, `Teacher`)
- **Value Objects**: Immutable objects (`Email`, `ScheduleDetails`)
- **Repositories**: Interfaces for data access (ports)
- **Domain Services**: Business logic

### Application Layer (`application/`)
- **Use Cases**: Application services orchestrating business logic
- **DTOs**: Data transfer objects for external communication
- **Ports**: Interfaces for external dependencies

### Infrastructure Layer (`infrastructure/`)
- **Persistence**: Database implementations and configurations
- **Config**: Application configuration classes
- **Security**: Security configurations

### Presentation Layer (`presentation/`)
- **Controllers**: REST API endpoints
- **Mappers**: Converting between entities and DTOs

## API Endpoints

The Java application provides the same REST API as the original Python version:

### Activities Management
- `GET /activities` - List all activities with optional filtering
- `GET /activities/days` - Get available days
- `POST /activities/{name}/signup` - Sign up student for activity
- `POST /activities/{name}/unregister` - Remove student from activity

### Authentication
- `POST /auth/login` - Teacher login
- `GET /auth/check-session` - Validate session

## Project Structure

```
src/
├── main/java/com/mergingtonhigh/schoolmanagement/
│   ├── domain/
│   │   ├── entities/          # Core business entities
│   │   ├── valueobjects/      # Immutable value objects
│   │   ├── repositories/      # Repository interfaces (ports)
│   │   └── services/          # Domain services
│   ├── application/
│   │   ├── usecases/         # Application services
│   │   ├── dtos/             # Data transfer objects
│   │   └── ports/            # Application ports
│   ├── infrastructure/
│   │   ├── persistence/      # Database implementations
│   │   ├── config/           # Configuration classes
│   │   └── security/         # Security configurations
│   └── presentation/
│       ├── controllers/      # REST controllers
│       └── mappers/          # Entity-DTO mappers
├── test/java/                # Unit and integration tests
└── resources/
    ├── static/               # Frontend files (HTML, CSS, JS)
    └── application.properties # Configuration
```

## Building and Running

### Prerequisites
- Java 21
- Maven 3.9+
- MongoDB (optional - application includes fallback)

### Build Commands
```bash
# Compile the project
mvn clean compile

# Run tests with coverage
mvn test

# Generate Jacoco coverage report
mvn jacoco:report

# Run the application
mvn spring-boot:run
```

### Test Coverage
The project includes comprehensive unit tests with Jacoco coverage reporting. Coverage reports are generated in `target/site/jacoco/`.

### Key Features Migrated
- ✅ Clean Architecture implementation
- ✅ All REST API endpoints
- ✅ Teacher authentication with Argon2 password hashing
- ✅ Student registration/unregistration
- ✅ Activity management with scheduling
- ✅ Input validation and error handling
- ✅ Unit tests with Mockito
- ✅ Test coverage with Jacoco
- ✅ Static file serving (frontend)

### Future Enhancements
- MongoDB integration (requires MongoDB server)
- Integration tests with TestContainers
- C4Model documentation diagrams
- PlantUML architecture diagrams
- Docker containerization
- Enhanced security features

## Quality Assurance

- **Clean Code**: Following SOLID principles
- **Test Coverage**: Comprehensive unit tests
- **Documentation**: Inline documentation and README
- **Architecture**: Clear separation of concerns
- **Error Handling**: Proper exception handling and HTTP status codes