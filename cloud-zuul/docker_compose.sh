#!/bin/bash

# config_version对应images的版本号，例如：scia/cloud-zuul:1.0.0

zuul_version=1.0.0 \
config_host_ip=192.168.1.100 \
eureka_host_ip=192.168.1.100 \
zipkin_host_ip=192.168.1.100 \
zuul_host_ip=192.168.1.100 \
docker-compose $@

# 构建并启动容器
#zuul_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#zuul_host_ip=192.168.1.100 \
#docker-compose up -d

# 重启容器
#zuul_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#zuul_host_ip=192.168.1.100 \
#eureka_version=1.0.0 docker-compose restart

# 停止容器
#zuul_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#zuul_host_ip=192.168.1.100 \
#eureka_version=1.0.0 docker-compose stop

# 卸载容器
#zuul_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#zuul_host_ip=192.168.1.100 \
#eureka_version=1.0.0 docker-compose down



