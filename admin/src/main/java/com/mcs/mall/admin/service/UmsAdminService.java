package com.mcs.mall.admin.service;

import com.mcs.mall.admin.dto.UmsAdminParam;
import com.mcs.mall.model.UmsAdmin;

import java.util.List;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    /*
    注册
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    List<UmsAdmin> getList(Integer pageNum, Integer pageSize);
}
