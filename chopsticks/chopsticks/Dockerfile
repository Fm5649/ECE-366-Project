FROM maven:3.8.7-eclipse-temurin-19-alpine AS build
ADD . /project
WORKDIR /project
ADD pom.xml /project
RUN mvn verify --fail-never
RUN mvn -e package

FROM eclipse-temurin:19-alpine
COPY --from=build /project/target/chopsticks-0.0.1-SNAPSHOT-spring-boot.jar /app/chopsticks.jar
ENTRYPOINT ["java","-jar","/app/chopsticks.jar"]
<<<<<<< HEAD
EXPOSE 5432
=======
>>>>>>> 491e781a2142b0421f3cf40331a840a7feab9e6c
