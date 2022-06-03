FROM gradle:7.4.2-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon


FROM openjdk:17-slim
COPY --from=build /home/gradle/src/build/libs/*all.jar /app/DiscordLanguageGaming.jar

ENTRYPOINT ["java", "-jar", "/app/DiscordLanguageGaming.jar"]
