package com.mcs.mall.admin.controller.rest;

import com.mcs.mall.admin.dto.PmsProductCategoryParam;
import com.mcs.mall.admin.service.PmsProductCategoryService;
import com.mcs.mall.model.PmsProductCategory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@ApiOperation("商品目录API")
public class ProductCategoryAPI {
    @Autowired
    PmsProductCategoryService categoryService;

    @PostMapping("/add")
    @ApiOperation(value = "添加商品分类", httpMethod = "POST")
    public PmsProductCategory create(PmsProductCategoryParam param) {
        return categoryService.save(param);
    }

    @GetMapping("/parent")
    @ApiOperation("所有0级分类")
    public List<PmsProductCategory> parent() {
        return categoryService.getParentList();
    }

}
