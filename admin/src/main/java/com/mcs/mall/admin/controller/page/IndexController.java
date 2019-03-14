package com.mcs.mall.admin.controller.page;

import com.mcs.mall.mapper.UmsAdminMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    UmsAdminMapper umsAdminDAO;
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

    @GetMapping("/all")
    public String all() {
        return umsAdminDAO.selectByPrimaryKey(6L).toString();
    }

}
