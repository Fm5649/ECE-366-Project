FROM maven:3.8.7-eclipse-temurin-19-alpine AS build
WORKDIR /project
ADD pom.xml /project
RUN mvn verify --fail-never
ADD . /project
RUN mvn -e package

FROM eclipse-temurin:19-alpine
COPY --from=build /project/target/chopsticks-0.0.1-SNAPSHOT-spring-boot.jar /app/chopsticks.jar
ADD secret.json /app
RUN ["ls"]
ENTRYPOINT ["java","-jar","/app/chopsticks.jar"]

