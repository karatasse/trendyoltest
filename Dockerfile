FROM java:8
EXPOSE 8080
ADD /target/trendyol-test-0.0.1-SNAPSHOT.jar trendyol-test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","trendyol-test-0.0.1-SNAPSHOT.jar"]