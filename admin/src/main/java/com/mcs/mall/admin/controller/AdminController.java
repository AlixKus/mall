package com.mcs.mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @ResponseBody
    @RequestMapping("/")
    public String h() {
        return "Hello";
    }


    @RequestMapping("/register")
    public String register() {
        return "admin/register";
    }

}
