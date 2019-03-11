package com.mcs.mall.admin.controller;

import com.mcs.mall.mapper.UmsAdminDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UmsAdminDAO umsAdminDAO;

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/all")
    public String all() {
        return umsAdminDAO.selectByPrimaryKey(6L).toString();
    }

}
