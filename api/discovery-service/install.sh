#!/bin/env sh

cd $(dirname $0)
./mvnw install -DskipTests=true -Dmaven.javadoc.skip=true -B -V