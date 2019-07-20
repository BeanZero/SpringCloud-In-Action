package com.scia.service.common.redis.service;

import java.util.concurrent.TimeUnit;

/**
 * @author BeanZero
 * @date 2019-05-19
 */
public interface RedisService {

    /**
     * 新增
     * @param key
     * @param value
     * @throws Exception
     */
    void set(String key, Object value) throws Exception;

    /**
     * 新增(过期时间)
     * @param key
     * @param value
     * @param timeout
     * @param unit
     * @throws Exception
     */
    void set(String key, Object value, long timeout, TimeUnit unit) throws Exception;

    /**
     * 获取
     * @param key
     * @return
     * @throws Exception
     */
    Object get(String key) throws Exception;

    /**
     * 获取(截取字符串)
     * @param key
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    String get(String key, long start, long end) throws Exception;

    /**
     * 获取旧值并用新值替换
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    Object getAndSet(String key, Object value) throws Exception;

    /**
     * 新增字符串到末尾
     * @param key
     * @param value
     * @throws Exception
     */
    void append(String key, String value) throws Exception;

    /**
     * 删除
     * @param key
     * @return
     * @throws Exception
     */
    boolean delete(String key) throws Exception;

    /**
     * 模糊匹配批量删除
     * @param prex
     * @throws Exception
     */
    void deleteByPrex(String prex) throws Exception;
}
