FROM eclipse-temurin
ENV DB_URL=$DB_URL
ENV DB_USER=$DB_USER
ENV DB_PASSWORD=$DB_PASSWORD
EXPOSE 8080
ADD target\epictaskapi-0.0.1-SNAPSHOT.jar epictaskapi.jar
ENTRYPOINT [ "java", "-jar", "epictaskapi.jar", "--spring.profiles.active=dev" ]
