FROM openjdk:11
ARG JAR_FILE=./build/libs/server-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} app.war
ENTRYPOINT ["java", "-jar", "/app.war"]