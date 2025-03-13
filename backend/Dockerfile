# Use OpenJDK 19 as the base image
FROM openjdk:19-jdk

# Set the working directory inside the container
WORKDIR /app

# # Copy environment variables file
# COPY .env .env
# Copy application properties
COPY ./user-service/src/main/resources/application.yml /app/application.yml

# Copy the built JAR file into the container
COPY ./user-service/target/user-service-1.0.0.jar app.jar


# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
