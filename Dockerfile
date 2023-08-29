FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} StarParts-API.jar
ENTRYPOINT ["java","-jar","/StarParts-API.jar"]