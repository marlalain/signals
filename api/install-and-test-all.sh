#!/bin/sh

# maven

# run installs
find . -name "install.sh" -exec sh {} \;

# run tests
find . -name "test.sh" -exec sh {} \;
