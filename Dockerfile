FROM openjdk:11
MAINTAINER Karthickeyan Subramanian
#Maven build -> finalName
ARG JAR_FILE=target/recipe-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
