package com.scia.service.provider.controller;

import com.scia.base.entity.CodeStatus;
import com.scia.base.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author BeanZero
 * @date 2019-04-24
 */
@RestController
public class ProviderController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/say/{speak}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result say(@PathVariable String speak, @RequestParam(required = false) String token) {
        return new Result(CodeStatus.SUCCESS.getValue(), CodeStatus.SUCCESS.getReasonPhrase(), new HashMap() {
            {
                put("name", name);
                put("port", port);
                put("msg", String.format("service port is [%s], he say [%s], token is [%s]", port, speak, token));
            }
        });
    }

}
