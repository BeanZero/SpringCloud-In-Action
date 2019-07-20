package com.scia.service.common.redis.service.impl;

import com.scia.service.common.redis.service.RedisCacheService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author BeanZero
 * @date 2019-06-03
 */
@Service
@CacheConfig(cacheNames = {"BasicDataCache"}, cacheManager = "cacheManager")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class RedisCacheServiceImpl implements RedisCacheService {

    @CachePut(key = "'cacheInfo'.concat(#key)", unless = "#result == null")
    @Override
    public <T> T save(String key, T value) {
        return value;
    }

    @CachePut(key = "'cacheInfoMap'.concat(#key)", unless = "#result == null")
    @Override
    public <T> Map<String, T> save(String key, Map<String, T> value) {
        return value;
    }

    @Cacheable(key = " 'cacheInfo'.concat(#key)", condition = "#key != null", unless = "#result == null")
    @Override
    public <T> T get(String key) {
        return null;
    }

    @Cacheable(key = " 'cacheInfoMap'.concat(#key)", condition = "#key != null")
    @Override
    public <T> Map<String, T> find(String key) {
        return null;
    }

    @CacheEvict(key = "'cacheInfo'.concat(#key)")
    @Override
    public void remove(String key) {
    }

    @CacheEvict(allEntries = true)
    @Override
    public void removeAll() {
    }
}
