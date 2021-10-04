FROM gradle:jdk11

MAINTAINER warder

COPY . /home/gradle/src

RUN gradle build

FROM adoptopenjdk/openjdk11

COPY /build/libs/*.jar /hello.jar

ENTRYPOINT ["java", "-jar", "/hello.jar"]


