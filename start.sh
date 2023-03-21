#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clear
mvn package

docker-compose stop

# Add environment variables
# To do ability to send variable from command line to start script
export BOT_NAME=test_anoc_bot
export BOT_TOKEN=6056442068:AAG782qRhUkOUbVdQLtaOZpzAzT5aIUtrwE
export BOT_DB_USERNAME='prod_anoc_db_user'
export BOT_DB_PASSWORD='Pap9L9VVUkNYj99GCUCC3mJkb'

docker-compose up --build -d