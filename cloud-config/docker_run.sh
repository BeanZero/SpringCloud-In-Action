#!/bin/bash

if [[ $# -lt 1 ]]; then
echo -e "param required : version \n"
exit
fi

docker run -d --privileged=true --name "cloud-config" -it --rm -p 8888:8888 -e ARGS="\
--ARGS_CONFIG_SECURITY_USERNAME=admin \
--ARGS_CONFIG_SECURITY_PASSWORD=111 \
--ARGS_CONFIG_SERVICE_PORT=8888 \
--ARGS_EUREKA1_HOSTNAME=eureka1 --ARGS_EUREKA1_PORT=8761 \
--ARGS_EUREKA2_HOSTNAME=eureka2 --ARGS_EUREKA2_PORT=8762 \
--ARGS_EUREKA3_HOSTNAME=eureka3 --ARGS_EUREKA3_PORT=8763" \
scia/cloud-config:$1