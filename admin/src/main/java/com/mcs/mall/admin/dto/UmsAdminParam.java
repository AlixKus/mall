package com.mcs.mall.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UmsAdminParam {

    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "用户头像")
    private String icon;
    @Email(message = "邮箱格式不合法")
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "备注")
    private String note;
}
