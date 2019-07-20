package com.scia.service.common.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author BeanZero
 * @date 2019-06-03
 */
public class Jackson2JsonRedisSerializerUtil {

    public static <T> Jackson2JsonRedisSerializer getJackson2JsonRedisSerializer(Class<T> type) {
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(type);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        serializer.setObjectMapper(objectMapper);
        return serializer;
    }

}
