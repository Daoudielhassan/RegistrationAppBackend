# Use a base image that includes OpenJDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and the pom.xml file
COPY mvnw* ./
COPY .mvn .mvn
COPY pom.xml ./

# Run Maven dependency resolution
RUN ./mvnw dependency:go-offline

# Copy the rest of the project files
COPY src ./src

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Expose the default port for Spring Boot (usually 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "target/your-app.jar"]
