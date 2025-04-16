FROM amazoncorretto:21
ARG JAR_NAME=target/*.jar
COPY ${JAR_NAME} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]