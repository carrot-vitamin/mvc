package com.project.common.entity;

/**
 * Created by yinshaobo on 2018/5/16
 * 响应码MAP类
 * E : ERROR
 * S : SUCCESS
 */
public enum ResponseCode {

    SUCCESS("200", "请求成功"),
    USER_NAME_EXISTED("E10000", "用户名已存在"),
    REGIST_ERROR("E10001", "注册异常"),
    USER_OR_PASS_ERROR("E10002", "用户名或密码错误");

    private String code;
    private String desc;

    ResponseCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
