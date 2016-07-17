#!/bin/bash

set -e

echo "What's the name of the module to be created? Abort by pressing [ENTER]:"
read NAME

if [ "$NAME" == '' ]; then
  echo "Cancelled..."
  exit 1
fi

ROOT=modules/
TARGET=$ROOT$NAME

if [ -d "$TARGET" ]; then
  echo "Module already exists..."
  exit 1
fi


mkdir -p $TARGET/src/main/java/de/egga
mkdir -p $TARGET/src/test/java/de/egga

touch $TARGET/build.gradle

echo "include 'modules:$NAME'" >> settings.gradle
echo "findProject(':modules:$NAME')?.name = '$NAME'" >> settings.gradle

cp -r modules/template/* $TARGET/


tree modules
cat settings.gradle