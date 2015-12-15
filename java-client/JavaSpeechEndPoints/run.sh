#!/bin/bash

cd /App
CP() { local IFS=:; echo "$*";}
javac -d . -cp "$(CP lib/*.jar)" src/com/gdg/app/javaEndPoints/*.java

CP() { local IFS=:; echo "$*";}
java -cp .:"$(CP lib/*.jar)":"$(CP src/*)" com.gdg.app.javaEndPoints.JavaEndPoints