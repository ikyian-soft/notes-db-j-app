#!/bin/bash

cd ..
docker build -t notes-db-j:latest -f docker/Dockerfile .