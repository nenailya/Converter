# Image with gradle on alpine, mark as build
FROM gradle:7.4-jdk11-alpine AS build
# Copy in contaier files
COPY .  /home/
# Working directory for new instruction
WORKDIR /home/
# Run and add new slice
RUN gradle build

# Image with jre
FROM openjdk:11-jre-slim
# Need to open 8081 port
EXPOSE 9001
# Create new directory for jar
RUN mkdir /app
# Move jar to directory
COPY --from=build /home/build/libs/converter-0.0.1-SNAPSHOT.jar /app/app.jar
#/home/out/artifacts/converter_main_jar/converter.main.jar /app/app.jar
# Run application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]