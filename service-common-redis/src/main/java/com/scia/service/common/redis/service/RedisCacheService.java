package com.scia.service.common.redis.service;

import java.util.Map;

/**
 * @author BeanZero
 * @date 2019-06-02
 */
public interface RedisCacheService {

    <T> T save(String key, T value);

    <T> Map<String, T> save(String key, Map<String, T> value);

    <T> T get(String key);

    <T> Map<String, T> find(String key);

    void remove(String key);

    void removeAll();

}
