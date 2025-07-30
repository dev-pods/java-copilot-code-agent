#!/bin/bash

# Set up Java development environment
echo "Setting up Java development environment..."

# Install Maven if not present
if ! command -v mvn &> /dev/null; then
    echo "Installing Maven..."
    sudo apt-get update
    sudo apt-get install -y maven
fi

# Install MongoDB tools (optional)
echo "Setting up MongoDB tools..."
sudo apt-get install -y mongodb-clients || echo "MongoDB clients installation skipped"

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