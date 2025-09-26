#!/bin/sh
# Builds the application using Maven and deploys the libraries.

set -e

# Check if mvn is installed
command -v mvn >/dev/null || { echo "Error: Maven (mvn) is not installed. Please install it and try again."; exit 1; }

. ./app.conf

cd "$REPO_DIR"

mvn clean package -U -Dmaven.test.skip=true "$1"

echo "Deploying libraries to $DEPLOY_DIR/lib ..."
rm -rf "${DEPLOY_DIR:?}"/lib/*
[ -d "$REPO_DIR/app/lib" ] && cp -pR "$REPO_DIR"/app/lib/* "$DEPLOY_DIR/lib"