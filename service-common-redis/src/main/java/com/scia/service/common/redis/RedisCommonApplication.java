package com.scia.service.common.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author BeanZero
 * @date 2019-05-19
 */
@SpringBootApplication
@EnableEurekaClient
public class RedisCommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisCommonApplication.class, args);
    }
}
