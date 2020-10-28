FROM maven:3.6.3-openjdk-11-slim

WORKDIR /shop-user

EXPOSE 2082

RUN addgroup -S shopuser && adduser -S -G shopuser shopuser && chown -R shopuser:shopuser /shop-user
user shopuser

COPY src src
COPY pom.xml ./pom.xml

RUN mvn package -DskipTests

cmd java -jar target/shop-user*.jar