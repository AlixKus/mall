package com.mcs.mall.admin.service;

import com.mcs.mall.admin.dto.UmsAdminParam;
import com.mcs.mall.model.UmsAdmin;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    /*
    注册
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);
}
