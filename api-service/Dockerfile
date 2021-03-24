FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY /build/libs/gas-price-tracker-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]