package com.mcs.mall.admin.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String hello() {
        return "vue";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
