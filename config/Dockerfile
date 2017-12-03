FROM java:8-jre

EXPOSE 8888

ADD build/libs/config.jar app/
CMD ["java", "-jar", "/app/config.jar"]