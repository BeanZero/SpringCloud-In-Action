package com.scia.service.common.redis.entity;

import com.scia.base.entity.BaseEntity;

/**
 * @author BeanZero
 * @date 2019-06-03
 */
public class CacheInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String phone;

    private String address;

    public CacheInfo() {
    }

    public CacheInfo(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CacheInfo{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
