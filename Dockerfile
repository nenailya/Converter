FROM gradle:7.4-jdk11-alpine AS build
COPY .  /home/
WORKDIR /home/
RUN gradle build

FROM openjdk:11-jre-slim
EXPOSE 9001
RUN mkdir /app
COPY --from=build /home/build/libs/converter-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]