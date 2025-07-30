#!/bin/bash

# Set up Java development environment
echo "Setting up Java development environment..."

# Prepare MongoDB Dev DB
chmod +x ./.devcontainer/installMongoDB.sh
./.devcontainer/installMongoDB.sh

# Set JAVA_HOME
export JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64
echo 'export JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64' >> ~/.bashrc

# Verify Java installation
java -version
mvn -version

# Install project dependencies
echo "Installing project dependencies..."
mvn dependency:resolve || echo "Dependencies will be resolved on first build"

echo "Java development environment setup complete!"
echo "Run 'mvn spring-boot:run' to start the application"
echo "Application will be available at http://localhost:8080"