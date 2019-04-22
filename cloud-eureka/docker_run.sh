#!/bin/bash

if [[ $# -lt 1 ]]; then
echo -e "param required : version \n"
exit
fi

docker run -d --privileged=true --name "cloud-eureka" -it --rm -p 8761:8761 -e ARGS="\
--ARGS_CONFIG_SECURITY_USERNAME=admin \
--ARGS_CONFIG_SECURITY_PASSWORD=111 \
--ARGS_CONFIG_SERVICE_PORT=8888 \
--ARGS_EUREKA_HOSTNAME=eureka3 --ARGS_EUREKA_SERVER_PORT=8763 \
--ARGS_EUREKA1_HOSTNAME=eureka1 --ARGS_EUREKA1_PORT=8761 \
--ARGS_EUREKA2_HOSTNAME=eureka2 --ARGS_EUREKA2_PORT=8762 \
--ARGS_EUREKA3_HOSTNAME=eureka3 --ARGS_EUREKA3_PORT=8763" \
scai/cloud-eureka:$1