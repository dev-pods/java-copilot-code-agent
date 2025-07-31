#!/bin/bash

# Prepare MongoDB Dev DB
chmod +x ./.devcontainer/installMongoDB.sh
./.devcontainer/installMongoDB.sh

# Set JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64
echo 'export JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64' >> ~/.bashrc

# Verify Java installation
echo "Verifying installation..."

# Check Java
if command -v java &> /dev/null; then
    echo "✓ Java is installed:"
    java -version
else
    echo "✗ Java is not installed or not in PATH"
    exit 1
fi

# Check javac
if command -v javac &> /dev/null; then
    echo "✓ Java compiler is available:"
    javac -version
else
    echo "✗ Java compiler (javac) is not installed or not in PATH"
    exit 1
fi

# Check Maven
if command -v mvn &> /dev/null; then
    echo "✓ Maven is installed:"
    mvn -version
else
    echo "✗ Maven is not installed or not in PATH"
    exit 1
fi

# Check MongoDB
if command -v mongo &> /dev/null || command -v mongosh &> /dev/null; then
    echo "✓ MongoDB client is available"
else
    echo "✗ MongoDB client is not installed or not in PATH"
    exit 1
fi

# Install project dependencies
echo "Installing project dependencies..."
mvn dependency:resolve || echo "Dependencies will be resolved on first build"

echo "Java development environment setup complete!"
echo "Run 'mvn spring-boot:run' to start the application"
echo "Application will be available at http://localhost:8080"