package com.scia.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BeanZero
 * @date 2019-04-24
 */
@RestController
public class ProviderController {

    @Value(value = "${server.port}")
    private String port;

    @GetMapping(value = "/say/{speak}")
    public String say(@PathVariable String speak, String token) {
        return String.format("service port is [%s], he say [%s], token is [%s]", port, speak, token);
    }

}
