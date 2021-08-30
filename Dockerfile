FROM adoptopenjdk/openjdk16:alpine-jre
ADD build/libs/*.jar run.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod", "-jar", "run.jar"]