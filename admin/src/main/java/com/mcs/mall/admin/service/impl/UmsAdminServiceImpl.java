package com.mcs.mall.admin.service.impl;

import com.mcs.mall.admin.dto.UmsAdminParam;
import com.mcs.mall.admin.service.UmsAdminService;
import com.mcs.mall.model.UmsAdmin;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private Logger logger = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        String salt = RandomStringUtils.randomAlphabetic(10, 20);
        umsAdmin.setSalt(salt);
        umsAdmin.setPassword(passwordEncoder.encode(salt + umsAdminParam.getPassword()));
        logger.info(umsAdmin.toString());
        return umsAdmin;
    }
}
