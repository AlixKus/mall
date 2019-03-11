package com.mcs.mall.admin.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UmsAdminParam {

    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String icon;
    @Email(message = "邮箱格式不合法")
    private String email;
    private String nickName;
    private String note;
}
