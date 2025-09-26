#!/bin/sh
# Deploys web application (front-end) files.
# It also restores specific web application files from the restore directory.

set -e

. ./app.conf

echo "Deploying web applications to $DEPLOY_DIR/webapps ..."
if [ -d "$REPO_DIR/app/webapps" ]; then
  [ ! -d "$DEPLOY_DIR/webapps" ] && mkdir -p "$DEPLOY_DIR/webapps"
  rm -rf "${DEPLOY_DIR:?}"/webapps/*
  cp -pR "$REPO_DIR"/app/webapps/* "$DEPLOY_DIR/webapps"
fi

echo "Restore specific web application files after deployment ..."
[ -d "$RESTORE_DIR/webapps" ] && cp -pRf "$RESTORE_DIR"/webapps/* "$DEPLOY_DIR/webapps"
