
## SpringCloud In Action

**基于目前最新的Greenwich版本：适用于微服务的学习或者二次开发**



### 模块说明

```
├─common-dependencies ------------- 统一父依赖：公用jar、版本号等信息。一般存放在Maven私服仓库中。
├─common-base --------------------- 基础模块，同上
├─cloud-config -------------------- 分布式配置中心
├─cloud-eureka -------------------- 服务注册中心(注册与发现)
├─cloud-zipkin -------------------- 分布式链路跟踪
├─cloud-zuul   -------------------- 路由网关
├─cloud-admin  -------------------- 服务监控
├─service-provider  --------------- 服务提供者(demo)
├─service-consumer-ribbon  -------- 服务消费者Ribbon模式(demo)
├─service-consumer-feign ---------- 服务消费者feign模式(demo)
```

### 关于Docker

```
1.每个子模块提供Dockerfile方便build镜像
2.每个子模块提供docker-compose.yml，支持负载均衡
3.考虑到正式生产环境不仅有专用的*-prod文件，很多涉密信息是在docker运行时候通过命令或者管理工具即时写入这里在全部做成参数形式，
可以在docker_compose.sh根据需要自行修改
```

### 未完待续
...