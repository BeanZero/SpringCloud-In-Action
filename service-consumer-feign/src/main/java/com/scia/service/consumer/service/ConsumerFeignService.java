package com.scia.service.consumer.service;

import com.scia.service.consumer.service.impl.ConsumerFeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author BeanZero
 * @date 2019-04-28
 */

@FeignClient(value = "service-provider", fallback = ConsumerFeignServiceHystrix.class)
public interface ConsumerFeignService {

    @GetMapping(value = "/say/{speak}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String sayRemote(@PathVariable String speak, @RequestParam(required = false) String token);

}
