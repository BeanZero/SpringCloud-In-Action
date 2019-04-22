#!/bin/bash

if [[ $# -lt 1 ]]; then
echo -e "param required : version \n"
exit
fi

mvn clean install -Dmaven.test.skip=true

docker rmi scia/cloud-config:$1

docker build -t scia/cloud-config:$1 .