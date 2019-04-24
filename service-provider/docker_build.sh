#!/bin/bash

if [[ $# -lt 1 ]]; then
echo -e "param required : version \n"
exit
fi

source ~/.bash_profile

mvn clean install -Dmaven.test.skip=true

docker rmi scia/service-provider:$1

docker build -t scia/service-provider:$1 .