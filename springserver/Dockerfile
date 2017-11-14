FROM openjdk:8-jdk-alpine
ADD target/springserver.jar springserver.jar
ENTRYPOINT exec java -jar springserver.jar
EXPOSE 8080