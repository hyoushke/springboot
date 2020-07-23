#!/usr/bin/env bash

export JAVA_HOME=/opt/jdk-13/
export APP_HOME=/k2u/data/springboot/builds/libs/
export APP_NAME=k2u-springboot
export APP_PORT=8085

export GRADLE_HOME=/opt/gradle/gradle-6.5.1
export PATH=${GRADLE_HOME}/bin:${PATH}

echo $JAVA_HOME
echo $APP_HOME
echo $APP_NAME
echo $APP_PORT

gradle clean package;
gradle build;
gradle clean build;
gradle build;

java -jar /k2u/data/springboot/build/libs/k2u-springboot-0.0.1.jar  --server.port=8085 --username=david --password=secret --host=localhost --databasename=users
