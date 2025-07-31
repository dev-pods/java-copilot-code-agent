### Copilot Instructions

This project is a Java 21 Spring Boot 3 application that requires:

- Java 21 (Temurin JDK)
- Maven 3.9+
- MongoDB for data persistence
- Spring Boot 3.3.6

The devcontainer is configured to provide Java 21 environment. When working on this project, ensure that:
1. Java 21 is being used (not Java 17)
2. Maven is available
3. MongoDB client tools are installed
4. All tests follow the Arrange-Act-Assert (AAA) pattern

The application implements Clean Architecture with proper separation between domain, application, infrastructure, and presentation layers.

## Technology Stack Details

- **Java 21 com Spring 3**: Latest LTS Java version with Spring Boot 3.3.6 framework
- **Banco de dados MongoDB**: NoSQL database for data persistence with Spring Data MongoDB
- **Clean Architecture**: Domain-driven design with clear layer separation (Domain, Application, Infrastructure, Presentation)
- **Testes unitários com Mockito e JUnit 5 (Jupiter)**: Comprehensive unit testing with dependency mocking
- **Cobertura de testes com Jacoco**: Test coverage reporting and quality gates
- **Documentação utilizando C4Model**: Architecture documentation with C4 model diagrams
- **Diagramas com PlantUML**: Visual architecture diagrams in docs/architecture/ directory
