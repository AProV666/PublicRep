#!/bin/bash

docker buildx build --platform linux/amd64 --push -t aprov/historyquotes:latest . -f Dockerfile-amd64
