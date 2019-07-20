package com.scia.service.common.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BeanZero
 * @date 2019-06-02
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    private static final long DEFAULT_EXPIRE_TIME = 60 * 3;

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        return new RedisCacheManager(redisCacheWriter,
                this.getRedisCacheConfigurationWithTtl(DEFAULT_EXPIRE_TIME),
                this.getRedisCacheConfigurationMap());
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Long seconds) {
        RedisSerializationContext.SerializationPair<Object> pair =
                RedisSerializationContext.SerializationPair.fromSerializer(
                        Jackson2JsonRedisSerializerUtil.getJackson2JsonRedisSerializer(Object.class)
                );
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair).entryTtl(Duration.ofSeconds(seconds));
        return redisCacheConfiguration;
    }

    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap();
        redisCacheConfigurationMap.put("SsoCache", this.getRedisCacheConfigurationWithTtl(DEFAULT_EXPIRE_TIME));
        redisCacheConfigurationMap.put("BasicDataCache", this.getRedisCacheConfigurationWithTtl(DEFAULT_EXPIRE_TIME));
        return redisCacheConfigurationMap;
    }

    @Override
    public CacheResolver cacheResolver() {
        return super.cacheResolver();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return super.errorHandler();
    }

}
