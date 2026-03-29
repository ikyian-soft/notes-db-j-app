# Use a lightweight Java runtime (Java 21 is typical for Spring Boot 4)
FROM eclipse-temurin:25-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file into the container
ADD target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]