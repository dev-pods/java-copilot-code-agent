# High School Management System - Java Edition

A modern web application for managing extracurricular activities at Mergington High School, built with Java 21 and Spring Boot 3.

## 🚀 Technology Stack

- **Java 21** - Latest LTS version with modern language features
- **Spring Boot 3.3.6** - Modern Spring framework
- **Spring Data MongoDB** - Database integration
- **Spring Security** - Authentication and authorization
- **Clean Architecture** - Domain-driven design principles
- **JUnit 5 & Mockito** - Comprehensive testing
- **Jacoco** - Test coverage reporting
- **Maven** - Build and dependency management
- **PlantUML** - Architecture documentation

## 🏗️ Architecture

This application follows **Clean Architecture** principles with clear separation of concerns:

```
📦 Domain Layer (Core Business Logic)
├── 🎯 Entities (Activity, Teacher)
├── 💎 Value Objects (Email, ScheduleDetails)
└── 🔌 Repository Interfaces

📦 Application Layer (Use Cases)
├── 🎪 Use Cases (Activity, Authentication, Registration)
└── 📋 DTOs (Data Transfer Objects)

📦 Infrastructure Layer (External Concerns)
├── 🗃️ MongoDB Repositories
├── 🔐 Security Configuration
└── ⚙️ Application Configuration

📦 Presentation Layer (Controllers)
├── 🌐 REST Controllers
└── 🔄 Entity-DTO Mappers
```

## 📋 Features

- **Activity Management**: Browse and filter extracurricular activities
- **Student Registration**: Sign up and unregister for activities
- **Teacher Authentication**: Secure login for teachers and administrators
- **Schedule Filtering**: Filter activities by day and time
- **Clean API**: RESTful endpoints with proper HTTP status codes
- **Frontend Integration**: Serves existing HTML/CSS/JavaScript frontend

## 🔗 API Endpoints

### Activities
- `GET /activities` - List all activities (with optional filtering)
- `GET /activities/days` - Get available days
- `POST /activities/{name}/signup` - Sign up student (requires teacher auth)
- `POST /activities/{name}/unregister` - Remove student (requires teacher auth)

### Authentication
- `POST /auth/login` - Teacher login
- `GET /auth/check-session` - Validate session

## 🛠️ Development

### Prerequisites
- Java 21 (Temurin distribution recommended)
- Maven 3.9+
- MongoDB (optional - application includes fallbacks)

### Quick Start

1. **Clone and build**:
   ```bash
   git clone <repository-url>
   cd school-management-system
   mvn clean compile
   ```

2. **Run tests**:
   ```bash
   mvn test
   ```

3. **Start the application**:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**:
   - Web interface: http://localhost:8080
   - API documentation: http://localhost:8080/swagger-ui.html (if enabled)

### Testing

The project includes comprehensive unit tests:

```bash
# Run all tests
mvn test

# Generate coverage report
mvn jacoco:report

# View coverage report
open target/site/jacoco/index.html
```

### Key Testing Features
- **Domain Entity Tests**: Validate business logic
- **Use Case Tests**: Mock external dependencies with Mockito
- **Repository Tests**: Integration testing with TestContainers
- **Coverage Reporting**: Jacoco integration

## 🏫 Default Data

The application initializes with sample data including:

- **Activities**: Chess Club, Programming Class, Soccer Team, Art Club, and more
- **Teachers**: Sample teacher accounts for testing
- **Students**: Pre-registered students in activities

### Default Teacher Accounts
- Username: `mrodriguez`, Password: `art123`
- Username: `mchen`, Password: `chess456` 
- Username: `principal`, Password: `admin789`

## 📊 Test Coverage

The project maintains high test coverage with:
- Domain entities: 100% coverage
- Use cases: Comprehensive mocking scenarios
- Integration points: External dependency validation

## 📖 Documentation

- **Architecture Diagrams**: Located in `docs/architecture/`
- **C4 Model**: System context, container, and component diagrams
- **PlantUML**: Generate diagrams with `mvn plantuml:generate`
- **API Documentation**: Integrated with Spring Boot

## 🔧 Configuration

Key configuration options in `application.properties`:

```properties
# Server Configuration
server.port=8080

# MongoDB (optional)
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=mergington_high

# Security
spring.security.user.name=admin
spring.security.user.password=admin123
```

## 🐳 Development Environment

This project supports GitHub Codespaces with pre-configured:
- Java 21 development environment
- Maven build tools
- VS Code extensions for Java development
- MongoDB tools (optional)

## 🚀 Deployment

The application can be deployed using:
- **JAR file**: `mvn clean package && java -jar target/school-management-system-*.jar`
- **Docker**: Create Dockerfile based on `openjdk:21-jre`
- **Cloud platforms**: Spring Boot compatible with most cloud providers

## 🤝 Contributing

1. Follow Clean Architecture principles
2. Write tests for all new features
3. Maintain test coverage above 80%
4. Use conventional commit messages
5. Update documentation for API changes

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Built with ❤️ using Clean Architecture and modern Java practices**