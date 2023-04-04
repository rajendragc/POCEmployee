FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/employee12-poc.jar employee12-poc.jar
ENTRYPOINT [ "java", "-jar", "/employee12-poc.jar" ]