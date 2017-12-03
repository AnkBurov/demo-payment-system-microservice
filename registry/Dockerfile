FROM java:8-jre

EXPOSE 8761

ADD build/libs/registry.jar app/
CMD ["java", "-jar", "/app/registry.jar"]