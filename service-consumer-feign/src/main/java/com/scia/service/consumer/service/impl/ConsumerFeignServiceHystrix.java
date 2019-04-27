package com.scia.service.consumer.service.impl;

import com.scia.base.entity.CodeStatus;
import com.scia.base.entity.Result;
import com.scia.service.consumer.service.ConsumerFeignService;
import org.springframework.stereotype.Component;

/**
 * @author BeanZero
 * @date 2019-04-28
 */
@Component
public class ConsumerFeignServiceHystrix implements ConsumerFeignService {

    @Override
    public String sayRemote(String speak, String token) {
        return new Result(CodeStatus.FAILED.getValue(), CodeStatus.FAILED.getReasonPhrase(),
                String.format("Your request message is [%s], token is [%s], but this request is failed !", speak, token)).toString();
    }

}
