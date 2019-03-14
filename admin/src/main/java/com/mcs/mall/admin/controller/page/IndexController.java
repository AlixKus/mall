package com.mcs.mall.admin.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @ResponseBody
    @GetMapping("/a")
    public String admin() {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/")
    public String hello() {
        return "vue";
    }

}
