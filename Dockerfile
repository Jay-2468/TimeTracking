#Building the application
FROM maven:3.9.9-amazoncorretto-21-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

#Creating a ligthweight runtime image
FROM alpine/java:21-jdk
WORKDIR /usr/local/tomcat/webapps

COPY --from=builder /app/target/TimeTracking-1.war app.war
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.war" ]