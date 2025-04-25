FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY ./target/hw-oracle-v0.jar ./app.jar
COPY ./example.yml ./example.yml
COPY ./example.keystore ./example.keystore
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "server", "example.yml"]
