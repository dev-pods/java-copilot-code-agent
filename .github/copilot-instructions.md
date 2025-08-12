# Mergington High School Management System - AI Coding Guidelines

## Entendimento do arquivo

> O check abaixo será utilizado no exercicio 3 deste repositório, o agente não deve marcar automaticamente e caso seja regerado o arquivo deverá manter a marcação anterior

[ ] - Aprendi sobre como configurar o copilot-instructions.

## Architecture Overview

This is a **Clean Architecture** Spring Boot application managing extracurricular activities. The codebase follows strict layer separation:

- **Domain Layer** (`src/main/java/.../domain/`): Pure business logic with entities, value objects, and repository interfaces
- **Application Layer** (`src/main/java/.../application/`): Use cases and DTOs that orchestrate domain logic
- **Infrastructure Layer** (`src/main/java/.../infrastructure/`): Database implementations, configurations, and external concerns
- **Presentation Layer** (`src/main/java/.../presentation/`): REST controllers and mappers

**Key Rule**: Dependencies flow inward - domain has no outward dependencies, application depends on domain, infrastructure implements domain interfaces.

## Critical Development Patterns

### Entity Validation Pattern

All domain entities validate themselves in constructors and setters:

```java
private String validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be null or empty");
    }
    return name.trim();
}
```

### Repository Implementation Pattern

- Interfaces in `domain/repositories/` (e.g., `ActivityRepository.java`)
- Implementations in `infrastructure/persistence/` with both Spring Data (`MongoActivityRepository`) and domain adapters (`ActivityRepositoryImpl`)

### Use Case Pattern

Application services in `application/usecases/` coordinate domain operations:

- Always validate teacher authentication first
- Use domain repositories through interfaces
- Transform entities to DTOs for external communication

### Error Handling Convention

Controllers return specific HTTP status codes:

- `401` for authentication failures
- `404` for "not found" messages
- `400` for validation errors
  Use `Map.of("detail", message)` for error responses.

## Essential Commands & Workflows

### Development Environment

1. **Database**: MongoDB required - use Docker: `docker run -d -p 27017:27017 --name mongodb mongo:latest`
2. **Environment**: Always use Java 21 - set `JAVA_HOME` and use `mvn -version` to verify
3. **Development Profile**: Set `SPRING_PROFILES_ACTIVE=dev` for CORS configuration

### Build & Test Commands

- **Build**: `mvn clean install` (includes tests)
- **Quick package**: `mvn package -DskipTests`
- **Run application**: `mvn spring-boot:run`
- **Test specific class**: `mvn test -Dtest=ActivityTest`
- **Coverage report**: `mvn jacoco:report`

### Database Migrations (Mongock)

- Migrations in `infrastructure/migrations/V001_InitialDatabaseSetup.java`
- Auto-executed on startup with `@ChangeUnit` annotation
- Uses environment variables for passwords (e.g., `TEACHER_RODRIGUEZ_PASSWORD`)
- Includes rollback methods with `@RollbackExecution`

## Key Technical Decisions

### Security Implementation

- **Argon2 password encoding** with BouncyCastle dependency
- **Basic authentication** via username/password in form data
- **CORS enabled** for development with `@CrossOrigin(origins = "*")`
- Security temporarily permissive (`permitAll()`) - authentication handled in use cases

### Testing Patterns

- **Unit tests**: `@ExtendWith(MockitoExtension.class)` with `@Mock` repositories
- **Integration tests**: Testcontainers for MongoDB (see dependencies)
- **Domain tests**: Direct entity testing with helper methods like `createTestActivity()`
- Test naming: `shouldDoSomethingWhenCondition()` format

### Frontend Integration

- **Static resources**: Served from `src/main/resources/static/`
- **API endpoints**: REST controllers under `/activities` and `/auth`
- **Form-based auth**: Uses `application/x-www-form-urlencoded` with `teacher_username` parameter
- **Response format**: JSON with consistent error structure

## Data Seeding & Environment

The system auto-seeds via Mongock with:

- **Teachers**: `mrodriguez`, `mchen`, `principal` (usernames)
- **Activities**: Chess Club, Programming Class, Art Club, etc.
- **Schedule format**: Uses `ScheduleDetails` value object with days list and `LocalTime`

Default passwords configurable via environment variables, fallback to secure defaults in code.

## Common Implementation Pitfalls

1. **Layer violations**: Never import infrastructure classes in domain layer
2. **Entity persistence**: Domain entities use Spring Data MongoDB annotations but remain persistence-agnostic
3. **Authentication flow**: Always validate teacher credentials in use cases, not security config
4. **Time handling**: Use `LocalTime` for schedules, store as `ScheduleDetails` value object
5. **Error consistency**: Use domain exceptions, translate to HTTP responses in controllers

When extending this system, follow the established patterns: create use cases for business logic, implement repository interfaces for data access, and maintain the clean dependency flow.
