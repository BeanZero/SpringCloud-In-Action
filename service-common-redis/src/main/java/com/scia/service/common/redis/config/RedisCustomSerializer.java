package com.scia.service.common.redis.config;

import com.scia.base.util.ProtoStuffSerializerUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author BeanZero
 * @date 2019-06-02
 */
public class RedisCustomSerializer implements RedisSerializer {

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return ProtoStuffSerializerUtil.serialize(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return null;
    }

}
