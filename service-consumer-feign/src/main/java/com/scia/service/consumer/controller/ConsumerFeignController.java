package com.scia.service.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scia.base.entity.CodeStatus;
import com.scia.base.entity.Result;
import com.scia.service.consumer.service.ConsumerFeignService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author BeanZero
 * @date 2019-04-28
 */
@RestController
public class ConsumerFeignController {

//    @Value("${spring.application.name}")
//    private String name;
//
//    @Value("${server.port}")
//    private String port;

    @Autowired
    private ConsumerFeignService consumerFeignService;

    @ApiOperation(value = "Fegin客户端调用演示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "speak", value = "消息", required = true, dataTypeClass = String.class, paramType = "path"),
            @ApiImplicitParam(name = "token", value = "令牌", required = false, dataTypeClass = String.class, paramType = "txt")
    })
    @GetMapping(value = "/say/{speak}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result sayRemote(@PathVariable String speak,
                            @RequestParam(required = false) String token) {
        String jsonString = consumerFeignService.sayRemote(speak, token);
        Result<JSONObject> result = JSON.parseObject(jsonString, Result.class);
        return result;
    }


}
