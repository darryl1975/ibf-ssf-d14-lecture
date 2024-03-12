# Build stage

FROM eclipse-temurin/21-jdk AS builder

# label the docker file
LABEL MAINTAINER="darrylng@nus.edu.sg"
LABEL APPLICATION="SSF Day 17 lecture"

ARG APP_DIR = /app

# dir where it will contain your src and target
WORKDIR ${APP_DIR}

# copy all required files to build the app into the image app folder
COPY mvnw.cmd .
COPY mvnw .
COPY pom.xml .
COPY src src
COPY .mvn .mvn

# use run command to run maven command to build the package, exclude unit testing
# download maven dependencies and build your jar file into target folder
RUN mvn package -Dmaven.test.skip=true

ENV PORT=8080

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar target/d14-lecture-0.0.1-SNAPSHOT.jar