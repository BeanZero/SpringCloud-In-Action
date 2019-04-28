#!/bin/bash

# config_version对应images的版本号，例如：scia/service-consumer-feign:1.0.0

consumer_feign_version=1.0.0 \
config_host_ip=192.168.1.100 \
eureka_host_ip=192.168.1.100 \
zipkin_host_ip=192.168.1.100 \
admin_host_ip=192.168.1.100 \
consumer_feign_host_ip=192.168.1.100 \
docker-compose $@

# 构建并启动容器
#consumer_feign_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#admin_host_ip=192.168.1.100 \
#consumer_feign_host_ip=192.168.1.100 \
#docker-compose up -d

# 重启容器
#consumer_feign_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#admin_host_ip=192.168.1.100 \
#consumer_feign_host_ip=192.168.1.100 \
#eureka_version=1.0.0 docker-compose restart

# 停止容器
#consumer_feign_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#admin_host_ip=192.168.1.100 \
#consumer_feign_host_ip=192.168.1.100 \
#eureka_version=1.0.0 docker-compose stop

# 卸载容器
#consumer_feign_version=1.0.0 \
#config_host_ip=192.168.1.100 \
#eureka_host_ip=192.168.1.100 \
#zipkin_host_ip=192.168.1.100 \
#admin_host_ip=192.168.1.100 \
#consumer_feign_host_ip=192.168.1.100 \
#eureka_version=1.0.0 docker-compose down



