# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:22-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project source code to the container
COPY . /app

# Install Maven (since you want to build the project inside the container)
RUN apk add --no-cache maven

# Build the application
RUN mvn clean package

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/target/RegistrationApplication-0.0.1-SNAPSHOT.jar"]
