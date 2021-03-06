package com.mcs.mall.admin.controller.page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
@Api(tags = "AdminController", description = "Admin后台页面")
public class AdminController {

    @GetMapping("/register")
    @ApiOperation(value = "后台注册页面", httpMethod = "GET")
    public String register() {
        return "admin/register";
    }

    @GetMapping("/info")
    @ApiOperation("当前登录用户信息页面")
    public String info() {
        return "admin/info";
    }

}
