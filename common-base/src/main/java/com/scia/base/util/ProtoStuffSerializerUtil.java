package com.scia.base.util;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author BeanZero
 * @date 2019-06-01
 */
public class ProtoStuffSerializerUtil {

    /**
     * 序列化对象
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T t) {
        if (t == null) {
//            throw new NullPointerException();
            return null;
        }
        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(t.getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] protostuff;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(t, schema, buffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            buffer.clear();
        }
        return protostuff;
    }

    /**
     * 序列化对象列表
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> byte[] serializeList(List<T> list) {
        if (list == null || list.isEmpty()) {
//            throw new NullPointerException();
            return null;
        }
        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(list.getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE * 2);
        byte[] protostuff;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            ProtostuffIOUtil.writeListTo(bos, list, schema, buffer);
            protostuff = bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            buffer.clear();
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return protostuff;
    }

    /**
     * 反序列化对象
     *
     * @param bytes
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] bytes, Class<T> target) {
        if (bytes == null || target == null) {
//            throw new NullPointerException();
            return null;
        }
        T result;
        try {
            result = target.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Schema<T> schema = RuntimeSchema.getSchema(target);
        ProtostuffIOUtil.mergeFrom(bytes, result, schema);
        return result;
    }

    /**
     * 反序列化对象列表
     *
     * @param bytes
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> deserializeList(byte[] bytes, Class<T> target) {
        if (bytes == null || target == null) {
//            throw new NullPointerException();
            return null;
        }
        List<T> result;
        Schema<T> schema = RuntimeSchema.getSchema(target);
        try {
            result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), schema);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
