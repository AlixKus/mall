package com.mcs.mall.admin.controller.page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
@Api(tags = "AdminController", description = "AdminController后台页面Controller")
public class AdminController {

    @GetMapping("/register")
    @ApiOperation(value = "后台注册页面", httpMethod = "GET")
    public String register() {
        return "admin/register";
    }


    @GetMapping("/info")
    @ApiOperation(value = "用户信息", httpMethod = "GET")
    public String admin() {
        return "admin/info";
    }
}
