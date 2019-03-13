package com.mcs.mall.admin.controller;

import com.mcs.mall.admin.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UmsAdminService adminService;

    @ResponseBody
    @RequestMapping("/")
    public String h() {
        return "Hello";
    }


    @RequestMapping("/register")
    public String register() {
        return "vue";
    }

}
