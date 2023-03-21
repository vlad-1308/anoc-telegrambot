FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_anoc_bot
ENV BOT_TOKEN=6056442068:AAG782qRhUkOUbVdQLtaOZpzAzT5aIUtrwE
ENV BOT_DB_USERNAME=anoc_db_user
ENV BOT_DB_PASSWORD=root
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "/app.jar"]