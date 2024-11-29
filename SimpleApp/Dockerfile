FROM eclipse-temurin:21-alpine
LABEL authors="gatomek"
WORKDIR /app
ARG JAR_FILE=target/SimpleApp.jar
COPY ${JAR_FILE} /app/app.jar
EXPOSE 5006
ENTRYPOINT ["java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006", "app.jar"]
