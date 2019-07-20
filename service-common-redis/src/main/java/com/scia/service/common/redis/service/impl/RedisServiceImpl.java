package com.scia.service.common.redis.service.impl;

import com.scia.service.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author BeanZero
 * @date 2019-05-19
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) throws Exception {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long timeout, TimeUnit unit) throws Exception {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    @Override
    public Object get(String key) throws Exception {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public String get(String key, long start, long end) throws Exception {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    @Override
    public Object getAndSet(String key, Object value) throws Exception {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    @Override
    public void append(String key, String value) throws Exception {
        redisTemplate.opsForValue().append(key, value);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return redisTemplate.delete(key);
    }

    @Override
    public void deleteByPrex(String prex) throws Exception {
        Set<String> keys = redisTemplate.keys(prex);
        if (keys != null && keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }
}
