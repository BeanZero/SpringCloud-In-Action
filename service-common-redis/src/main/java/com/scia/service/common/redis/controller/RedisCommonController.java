package com.scia.service.common.redis.controller;

import com.scia.service.common.redis.entity.CacheInfo;
import com.scia.service.common.redis.service.RedisCacheService;
import com.scia.service.common.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author BeanZero
 * @date 2019-05-19
 */
@RestController
public class RedisCommonController {

    private Logger logger = LoggerFactory.getLogger(RedisCommonController.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisCacheService redisCacheService;

    @PostMapping(value = "set")
    public void set(@RequestParam String key, @RequestParam String value,
                    @RequestParam(required = false, defaultValue = "-1") long timeout){
        try {

            CacheInfo cacheInfo = redisCacheService.get("c1");
            System.out.println(cacheInfo != null ? cacheInfo.toString() : "");

            redisCacheService.save("c2", new HashMap<String, CacheInfo>() {
                {
                    put("zhangsan", new CacheInfo("张三", "18616596831", "田林路200号"));
                    put("lisi", new CacheInfo("李四", "17621922508", "田林路201号"));
                    put("wangwu", new CacheInfo("王五", "12345676894", "田林路202号"));
                }
            });




        } catch (Exception e) {
            logger.error("redis set error : ", e);
        }
    }

}
