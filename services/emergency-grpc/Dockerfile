FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Need os-maven-plugin extension for protobuf detection
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/emergency-grpc-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar"]