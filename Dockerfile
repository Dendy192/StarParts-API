FROM eclipse-temurin:17-jdk-alpine
EXPOSE 3256
ADD target/startpart-api.jar startpart-api.jar
ENTRYPOINT ["java","-jar","/startpart-api.jar"]