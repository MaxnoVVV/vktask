FROM openjdk:21-oracle
ADD target/VK-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]