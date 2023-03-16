#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clear
mvn package

docker-compose stop

# Add environment variables
export BOT_NAME=${1}
export BOT_TOKEN=${2}

docker-compose up --build -d