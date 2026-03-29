#!/bin/bash

cd ..

# database data folder
DATA_DIR=data
export DATA_DIR_PATH=${PWD}/${DATA_DIR}

mkdir -p $DATA_DIR

# deploy K8s
cd k8s

NAMESPACE_NAME=mysql

kubectl create namespace $NAMESPACE_NAME
envsubst < 00-config.yaml | kubectl apply -n $NAMESPACE_NAME -f -
kubectl apply -f 01-mysql.yaml -n $NAMESPACE_NAME
kubectl apply -f 02-adminer.yaml -n $NAMESPACE_NAME

export DB_ROOT_PASS=$(kubectl get configmap app-config -n mysql -o json | jq -r ".data.db_root_password")
export DB_USER=$(kubectl get configmap app-config -n mysql -o json | jq -r ".data.db_user_name")
export DB_PASS=$(kubectl get configmap app-config -n mysql -o json | jq -r ".data.db_user_password")

envsubst < 03-db-init-job.yaml | kubectl apply -n $NAMESPACE_NAME -f -
kubectl apply -f 04-notes-app.yaml -n $NAMESPACE_NAME 
