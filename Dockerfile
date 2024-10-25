# Use a Maven image to build the application
FROM maven:3.8.4-openjdk-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and the source code to the working directory
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package

# Use a lightweight JDK image to run the application
FROM openjdk:21-jdk-slim

# Expose the application port
EXPOSE 9090

# Copy the built JAR file from the build stage to the run stage
COPY --from=build /app/target/ICM-1.0.0.jar chat.jar

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "ICM-1.0.0.jar"]