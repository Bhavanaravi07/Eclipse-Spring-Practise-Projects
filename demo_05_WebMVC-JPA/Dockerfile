FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/Demo_05_WebMVC-JPA-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]