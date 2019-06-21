FROM java:8-jre

COPY target/pricemanagements-0.0.2-SNAPSHOT.jar /opt
COPY target/pricemanagements-0.0.2-SNAPSHOT.jar.original /opt/pricemanagements-0.0.2-SNAPSHOT.jar

EXPOSE 9999

CMD ["java", "-jar", "/opt/pricemanagements-0.0.2-SNAPSHOT.jar"]