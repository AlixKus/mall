package com.mcs.mall.admin.controller.rest;

import com.mcs.mall.admin.dto.UmsAdminParam;
import com.mcs.mall.admin.service.UmsAdminService;
import com.mcs.mall.admin.vo.AdminVO;
import com.mcs.mall.admin.vo.AdminVOFactory;
import com.mcs.mall.model.UmsAdmin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin API REST", description = "Admin API 后台管理")
public class AdminAPI {

    private Logger logger = LoggerFactory.getLogger(AdminAPI.class);

    @Autowired
    UmsAdminService adminService;

    @GetMapping("")
    @ApiOperation("当前登录用户信息")
    public AdminVO admin(Authentication authentication) {
        AdminVO adminVo = AdminVOFactory.getAdmin(authentication);
        return adminVo;
    }

    @GetMapping("/list")
    @ApiOperation("Admin分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "n", defaultValue = "1", value = "PageNum"), @ApiImplicitParam(name = "s", defaultValue = "10", value = "PageSize")})
    public List<UmsAdmin> listAdmin(@RequestParam(name = "n", defaultValue = "1") Integer num, @RequestParam(name = "s", defaultValue = "10") Integer size) {
        logger.info(num + ":" + size);
        return adminService.getList(num, size);
    }


    @PostMapping("/register")
    @ApiOperation(value = "后台用户注册", httpMethod = "POST")
    public UmsAdmin register(UmsAdminParam adminParam) {
        return adminService.register(adminParam);
    }

}
