FROM java:8-jdk-alpine

COPY target/reverseInex-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java", "-jar", "reverseInex-0.0.1-SNAPSHOT.jar"]