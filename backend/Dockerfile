# Use OpenJDK 19 as the base image
FROM openjdk:19-jdk

# Set the working directory inside the container
WORKDIR /app

# # Copy environment variables file
# COPY .env .env
# Copy application properties
COPY src/main/resources/application.properties /app/application.properties 

# Copy the built JAR file into the container
COPY user-service/target/friendalyze-1.0.0.jar /app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
