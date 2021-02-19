#!/bin/bash -eu

cd $(dirname $0)/..

trap "docker-compose down --volumes --remove-orphans" 0

docker-compose up --build --abort-on-container-exit