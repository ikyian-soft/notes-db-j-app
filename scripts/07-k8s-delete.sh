#!/bin/bash

NAMESPACE_NAME=mysql

kubectl delete namespace $NAMESPACE_NAME
kubectl delete pv mysql-pv-volume
