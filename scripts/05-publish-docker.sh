#!/bin/bash

export IMAGE_NAME=notes-db-j
export IMAGE_VERSION=1

docker image tag ${IMAGE_NAME}:latest ykyy/${IMAGE_NAME}:${IMAGE_VERSION}
docker push ykyy/${IMAGE_NAME}:${IMAGE_VERSION}