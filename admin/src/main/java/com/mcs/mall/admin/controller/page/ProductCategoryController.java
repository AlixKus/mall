package com.mcs.mall.admin.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class ProductCategoryController {

    @GetMapping("/add")
    public String add() {
        return "category/add";
    }

}
