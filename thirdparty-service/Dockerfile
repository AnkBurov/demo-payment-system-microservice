FROM java:8-jre

EXPOSE 8081

ADD build/libs/thirdparty-service.jar app/
CMD ["java", "-jar", "/app/thirdparty-service.jar"]