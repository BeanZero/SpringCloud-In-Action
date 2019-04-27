package com.scia.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author BeanZero
 * @date 2019-04-27
 */

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class ConsumerRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }
}
