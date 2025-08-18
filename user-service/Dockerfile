# Use JDK 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR built by Gradle
COPY build/libs/user-service-*.jar app.jar

# Expose port
EXPOSE 8083

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
