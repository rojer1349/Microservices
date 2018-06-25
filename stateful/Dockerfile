FROM openjdk:8-jdk-alpine
COPY /tmp/state /tmp
VOLUME /tmp
ARG JAR_FILE
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
COPY target/stateful.jar app.jar
