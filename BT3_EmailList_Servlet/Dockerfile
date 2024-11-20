
FROM tomcat:9-jdk17-openjdk-slim
RUN mkdir -p /app
COPY target/MurachWeb-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
