FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
COPY src ./mongo-service/src
RUN mvn clean package

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/service-mongoDB*.jar /app/mongo-service/service-mongoDB.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/app/mongo-service/service-mongoDB.jar"]