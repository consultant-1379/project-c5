FROM maven:3.8.1-jdk-8-slim as build
WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn install -DskipTests

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /workspace/app/target/cnmm*.jar /app/
WORKDIR /app
ENTRYPOINT ["java","-jar","cnmm-0.0.1-SNAPSHOT.jar"]