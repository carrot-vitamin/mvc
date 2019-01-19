package com.project.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yinshaobo on 2018/5/17
 */
@Setter
@Getter
public class Response {

    private Response() {
        this.responseCode = ResponseCode.SUCCESS.getCode();
        this.responseMessage = ResponseCode.SUCCESS.getDesc();
    }

    /**
     * 响应码
     */
    private String responseCode;

    /**
     * 响应信息
     */
    private String responseMessage;

    private Object data;

    private Response(Object data) {
        this.responseCode = ResponseCode.SUCCESS.getCode();
        this.responseMessage = ResponseCode.SUCCESS.getDesc();
        this.data = data;
    }

    private Response(ResponseCode code) {
        this.responseCode = code.getCode();
        this.responseMessage = code.getDesc();
    }

    public static Response success(Object data) {
        return new Response(data);
    }

    public static Response success() {
        return new Response();
    }

    public static Response fail(ResponseCode code) {
        return new Response(code);
    }

}
