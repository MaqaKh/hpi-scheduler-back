# Use an official Gradle image to build the application
FROM gradle:7.6.1-jdk17 AS build
WORKDIR /home/app
COPY . .
RUN gradle build -x test

# Use OpenJDK 17 image to run the application
FROM openjdk:17
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /home/app/build/libs/communitynotes-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java","-jar","/app/app.jar", "--spring.profiles.active=dev"] 