# Install maven and compile project
FROM maven:3.5-jdk-8 as maven

# copy the project files
COPY ./pom.xml /commodities/pom.xml
WORKDIR /commodities
# build all dependencies
RUN mvn dependency:go-offline -B
# copy your other files
COPY ./src /commodities/src
RUN mvn package


FROM openjdk:8-jdk-alpine
WORKDIR /commodities
# copy over the built artifact from the maven image
COPY --from=maven /commodities/target/commodities-0.0.1-SNAPSHOT.jar commodities-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","commodities-0.0.1-SNAPSHOT.jar"]
