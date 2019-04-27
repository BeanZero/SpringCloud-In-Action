package com.scia.service.consumer.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.scia.base.entity.CodeStatus;
import com.scia.base.entity.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author BeanZero
 * @date 2019-04-27
 */
@Service
public class ConsumerRibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayRemoteError")
    public Result<JSONObject> sayRemote(String speak, String token) {
        String jsonString = restTemplate.getForObject(new StringBuilder("http://service-provider/say/")
                        .append(speak).append("/")
                        .append(StringUtils.isNotBlank(token) ? "?token=" + token: "")
                        .toString(), String.class);
        Result<JSONObject> results = JSON.parseObject(jsonString, Result.class);
        return results;
    }

    public Result<JSONObject> sayRemoteError(String speak, String token) {
        return new Result(CodeStatus.FAILED.getValue(), CodeStatus.FAILED.getReasonPhrase(),
                String.format("Your request message is [%s], token is [%s], but this request is failed !", speak, token));
    }

}
