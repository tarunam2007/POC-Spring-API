FROM java:8-jre

COPY src/target/pricemanagements-0.0.2-SNAPSHOT.jar /opt

EXPOSE 9999

CMD ["java", "-jar", "/opt/pricemanagements-0.0.2-SNAPSHOT.jar"]