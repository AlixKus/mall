package com.mcs.mall.admin.controller.page;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "商品管理", description = "商品管理页面")
@RequestMapping("/product")
public class ProductController {
    @GetMapping("add")
    public String add() {
        return "product/add";
    }

    @GetMapping("list")
    public String list() {
        return "product/list";
    }
}
