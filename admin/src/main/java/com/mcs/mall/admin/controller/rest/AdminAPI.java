package com.mcs.mall.admin.controller.rest;

import com.mcs.mall.admin.dto.UmsAdminParam;
import com.mcs.mall.admin.service.UmsAdminService;
import com.mcs.mall.model.UmsAdmin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin API REST", description = "Admin API 后台管理")
public class AdminAPI {

    @Autowired
    UmsAdminService adminService;

    @PostMapping("/register")
    @ApiOperation(value = "后台用户注册", httpMethod = "POST")
    public UmsAdmin register(UmsAdminParam adminParam) {
        return adminService.register(adminParam);
    }

}
