FROM openjdk:8-jdk-alpine
ADD target/*.jar user-rest-api.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","user-rest-api.jar"]