package com.mcs.mall.admin.controller.page;

import com.mcs.mall.admin.vo.AdminVO;
import com.mcs.mall.admin.vo.AdminVOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @ResponseBody
    @GetMapping("/a")
    public String admin(Authentication authentication) {
        AdminVO adminVo = AdminVOFactory.getAdmin(authentication);
        return adminVo.toString();
    }

    @GetMapping("/")
    public String hello() {
        return "vue";
    }

}
