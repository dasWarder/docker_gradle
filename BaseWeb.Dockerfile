FROM gradle:jdk11-slim

COPY /. /home/gradle/src

RUN gradle build

FROM openjdk:11-jdk-slim

COPY /build/libs/*.jar /hello.jar

ENTRYPOINT ["java", "-jar", "/hello.jar"]
