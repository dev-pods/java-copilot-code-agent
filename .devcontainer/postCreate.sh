#!/bin/bash

##############################################################
# Install additional packages after the container is created
##############################################################
sudo apt-get update -y
sudo apt install -y sl libgpm2 libncurses6

##############################################################
# Install MongoDB (apt-get)
##############################################################

sudo apt-get install gnupg curl
curl -fsSL https://www.mongodb.org/static/pgp/server-8.0.asc | \
    sudo gpg -o /usr/share/keyrings/mongodb-server-8.0.gpg \
    --dearmor
echo "deb [ signed-by=/usr/share/keyrings/mongodb-server-8.0.gpg ] http://repo.mongodb.org/apt/debian bookworm/mongodb-org/8.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-8.0.list
sudo apt-get update -y
sudo apt-get install -y mongodb-org

# Create necessary directories and set permissions
sudo mkdir -p /data/db
sudo chown -R mongodb:mongodb /data/db

# Start MongoDB service
sudo mongod --fork --logpath /var/log/mongodb/mongod.log

#echo "MongoDB has been installed and started successfully!"
mongod --version

# Run sample MongoDB commands
echo "Current databases:"
mongosh --eval "db.getMongo().getDBNames()"

##############################################################
# Setup Java environment
##############################################################
echo "Setting up Java development environment..."

# Ensure Java 21 is used by Maven
export JAVA_HOME=/usr/local/sdkman/candidates/java/current
export PATH=$JAVA_HOME/bin:$PATH

# Set Maven to use Java 21 explicitly  
echo "Java version:"
java -version
echo "Maven Java version:"
mvn -version

# Build the project to ensure all dependencies are downloaded
echo "Building project..."
mvn clean install -DskipTests

# Setup debug and test environment
echo "Setting up debug and test environment..."

# Update Java configurations
echo "Updating Java configurations..."
touch .vscode/launch.json
touch .vscode/settings.json
touch .vscode/tasks.json

# Setup environment variables for development
export SPRING_PROFILES_ACTIVE=dev

# Verify Docker is accessible for Testcontainers
echo "Checking Docker access for Testcontainers..."
docker info > /dev/null 2>&1 && echo "Docker is accessible" || echo "Warning: Docker may not be accessible for tests"

echo "Development environment setup complete!"