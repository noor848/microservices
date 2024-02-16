FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/*.jar /app

EXPOSE 9090

CMD ["java", "-jar", "show-data.jar"]