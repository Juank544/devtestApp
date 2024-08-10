FROM amazoncorretto:21-alpine
LABEL authors="JUANK544"

WORKDIR /app
COPY build/libs/devtest-0.0.1-SNAPSHOT.war /app/devtest-0.0.1-SNAPSHOT.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/devtest-0.0.1-SNAPSHOT.war"]