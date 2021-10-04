FROM gradle:jdk11-slim

MAINTAINER warder

COPY /. /home/src/gradle
RUN gradle build

FROM openjdk:11-jdk-slim

ARG FILE=/build/libs/*.jar
COPY $FILE /persons.jar

ENTRYPOINT ["java", "-jar", "/persons.jar"]

