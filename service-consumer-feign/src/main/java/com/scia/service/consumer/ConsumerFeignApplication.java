package com.scia.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author BeanZero
 * @date 2019-04-28
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableSwagger2
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }
}
