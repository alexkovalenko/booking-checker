FROM java:8-jre
VOLUME /tmp
ARG JAR_FILE=./target/booking-checker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
EXPOSE 9091
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]