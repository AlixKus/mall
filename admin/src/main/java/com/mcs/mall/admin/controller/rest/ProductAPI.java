package com.mcs.mall.admin.controller.rest;

import com.mcs.mall.admin.dto.CommonResult;
import com.mcs.mall.admin.dto.PmsProductParam;
import com.mcs.mall.admin.service.PmsProductService;
import com.mcs.mall.model.PmsProductWithBLOBs;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductAPI {

    @Autowired
    PmsProductService productService;

    @PostMapping("/add")
    @ApiOperation("添加商品")
    public CommonResult add(PmsProductParam param) {
        productService.create(param);
        return CommonResult.success();
    }

    @GetMapping("/listapi")
    @ApiOperation("商品列表")
    public CommonResult list(@RequestParam(name = "n", defaultValue = "1") Integer num, @RequestParam(name = "s", defaultValue = "10") Integer size) {
        List<PmsProductWithBLOBs> list = productService.list(num, size);
        return CommonResult.success(list);
    }

    @GetMapping("/dwad")
    public PmsProductParam json() {
        return
                new PmsProductParam();
    }

}
