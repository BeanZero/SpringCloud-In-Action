package com.scia.service.common.redis.service;

import com.scia.service.common.redis.entity.CacheInfo;

import java.util.Map;

/**
 * @author BeanZero
 * @date 2019-06-03
 */
public interface CacheInfoService {

    CacheInfo saveCacheInfo(String name, CacheInfo cacheInfo);

    CacheInfo getCacheInfo(String name);

    Map<String, CacheInfo> saveCacheInfo(String name, Map<String, CacheInfo> map);

    Map<String, CacheInfo> getCacheInfo(String name, Map<String, CacheInfo> map);

}
