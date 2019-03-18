package com.mcs.mall.admin.dto;

import lombok.Getter;
import lombok.Setter;

/*
通用返回对象
 */
@Getter
@Setter
public class CommonResult {
    //操作成功
    public static final int SUCCESS = 200;
    //操作失败
    public static final int FAILED = 500;
    //参数校验失败
    public static final int VALIDATE_FAILED = 404;
    //未认证
    public static final int UNAUTHORIZED = 401;
    //未授权
    public static final int FORBIDDEN = 403;

    private int code;
    private String message;
    private Object data;


    public static CommonResult success() {
        return success(null);
    }

    public static CommonResult fail() {
        return fail(null);
    }

    public static CommonResult success(Object data) {
        return new CommonResult()._success(data);
    }

    public static CommonResult fail(Object data) {
        return new CommonResult()._fail(data);
    }

    /**
     * 普通成功返回
     *
     * @param data 获取的数据
     */
    private CommonResult _success(Object data) {
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = data;
        return this;
    }

    private CommonResult _fail(Object data) {
        this.code = FAILED;
        this.message = "操作失败";
        this.data = data;
        return this;
    }
}
