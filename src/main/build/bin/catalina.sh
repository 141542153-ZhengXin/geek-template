#!/bin/bash

TITLE="geek-template"
APP_DIR="./lib"
APP_PATTERN="$APP_DIR/geek-template*.jar"
APP_RUN=`ls -l $APP_PATTERN | awk '{print $9}'`
RUN_SERVER=`ps -ef | grep java | grep $APP_RUN |grep -v grep | awk '{print $2}'`
if [ $1 == "start" ]
then
  if [ -z "$JAVA_HOME" ]
  then
    echo java home:$JAVA_HOME
    echo java version:
    java -version
  fi
  echo start $TITLE
  nohup java -jar $APP_RUN --spring.conf.location = ./conf/ >/dev/null 2>&1 &
elif [ $1 == "stop" ]
then
  echo stop $TITLE
  kill -9 $RUN_SERVER
fi