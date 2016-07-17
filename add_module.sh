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

mkdir $TARGET

echo "include 'modules:$NAME'" >> settings.gradle
echo "findProject(':modules:$NAME')?.name = '$NAME'" >> settings.gradle

cp -r modules/template/* $TARGET/


tree modules
cat settings.gradle