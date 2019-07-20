package com.scia.service.common.redis.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * @author BeanZero
 * @date 2019-06-02
 */
public class RedisCustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append(target.getClass().getSimpleName()).append(".");
        sb.append(method.getName()).append("[");
        if (params != null && params.length > 0) {
            for (Object param : params) {
                sb.append(param.toString());
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
