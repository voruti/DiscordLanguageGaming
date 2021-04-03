FROM gradle:6.7-jdk11-openj9 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon


FROM openjdk:11-jre-slim
COPY --from=build /home/gradle/src/build/libs/*all.jar /app/DiscordLanguageGaming.jar

ENTRYPOINT ["java","-jar","/app/DiscordLanguageGaming.jar"]
