package com.mcs.mall.admin.controller.page;

import com.mcs.mall.admin.dto.UmsAdminParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {
    @GetMapping("/UmsAdminParam")
    public UmsAdminParam dtoAdminParam() {
        return new UmsAdminParam();
    }

}
