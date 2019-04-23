#!/bin/bash

# config_version对应images的版本号，例如：scia/cloud-config:1.0.0

# 构建并启动容器
config_version=1.0.0 \
eureka_host_ip=10.2.230.108 \
docker-compose up -d

# 重启容器
#config_version=1.0.0 \
#eureka_host_ip=10.2.230.108 \
#config_version=1.0.0 docker-compose restart

# 停止容器
#config_version=1.0.0 \
#eureka_host_ip=10.2.230.108 \
#config_version=1.0.0 docker-compose stop

# 卸载容器
#config_version=1.0.0 \
#eureka_host_ip=10.2.230.108 \
#config_version=1.0.0 docker-compose down



