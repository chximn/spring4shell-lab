FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app
ADD pom.xml /app
RUN mvn dependency:go-offline

ADD src/ /app/src
RUN mvn package

FROM tomcat:9.0.48-jdk11-openjdk-slim AS server

COPY --from=build /app/target/hello.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]