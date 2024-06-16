FROM maven:3.8.4-openjdk-17
LABEL authors="abdelaziz"
WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "/app/target/crud-0.0.1-SNAPSHOT.war"]