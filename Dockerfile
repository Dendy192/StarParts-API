EXPOSE 3256
ADD target/startpart-api.jar startpart-api.jar
ENTRYPOINT ["java","-jar","/startpart-api.jar"]

