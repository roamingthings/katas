#!/bin/bash

set -ex

NAME=template
ROOT=modules/

mkdir -p $ROOT$NAME/src/main/java/de/egga
mkdir -p $ROOT$NAME/src/test/java/de/egga
touch $ROOT$NAME/build.gradle
echo "include 'modules:$NAME'" >> settings.gradle
echo "findProject(':modules:$NAME')?.name = '$NAME'" >> settings.gradle


tree modules
cat settings.gradle