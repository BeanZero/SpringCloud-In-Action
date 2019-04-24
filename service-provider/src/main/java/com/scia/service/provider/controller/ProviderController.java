package com.scia.service.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BeanZero
 * @date 2019-04-24
 */
@RestController
public class ProviderController {

    @GetMapping(value = "/demo")
    public String demo(String msg) {
        return String.format("demo is [%s]", msg);
    }

}
