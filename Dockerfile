FROM java:8-jre

COPY target/pricemanagements-0.0.2-SNAPSHOT.jar /opt/pricemanagements-0.0.2-SNAPSHOT.jar

EXPOSE 8090

CMD ["java", "-jar", "/opt/pricemanagements-0.0.2-SNAPSHOT.jar"]