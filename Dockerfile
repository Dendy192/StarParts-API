FROM eclipse-temurin:17-jdk-alpine
ADD  robot-0.0.1-SNAPSHOT.jar StarParts-API.jar
ENTRYPOINT ["java","-jar","/StarParts-API.jar"]