FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
