# Stage 1: Build the Maven project
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

# Stage 2: Create the final Docker image with Tomcat
FROM tomcat:9.0-jdk11-corretto-al2
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN rm -rf /usr/local/tomcat/webapps/examples

ADD home.war /usr/local/tomcat/webapps/

# Add MySQL JDBC driver
COPY --from=build /root/.m2/repository/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar /usr/local/tomcat/lib/

# Copy your application WAR file
COPY --from=build /app/target/home.war /usr/local/tomcat/webapps/

# Set environment variables for MySQL connection
ENV DB_URL=jdbc:mysql://mysql_host:3306/doanweb
ENV DB_USERNAME=root
ENV DB_PASSWORD=1234567890

EXPOSE 8080
CMD ["catalina.sh", "run"]