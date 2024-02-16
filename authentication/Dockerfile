FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/authentication.jar /app

EXPOSE 7070

CMD ["java", "-jar", "authentication.jar"]