package com.scia.base.entity;

/**
 * @author BeanZero
 * @date 2019-04-26
 */
public enum CodeStatus {

    SUCCESS(20000, "成功"),

    FAILED(10000, "失败"),

    UNAUTHORIZED(40001, "未经许可"),

    NOT_FOUND(40400, "信息不存在"),

    ERROR(50000, "错误"),

    LOGINERROR(50001, "用户名或密码错误"),

    REMOTEERROR(50002, "远程调用失败"),

    TOKENERROR(50003, "令牌失效");

    private final int value;

    private final String reasonPhrase;

    CodeStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

}
