package com.mcs.mall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mcs.mall.admin.dto.UmsAdminParam;
import com.mcs.mall.admin.service.UmsAdminService;
import com.mcs.mall.mapper.UmsAdminMapper;
import com.mcs.mall.model.UmsAdmin;
import com.mcs.mall.model.UmsAdminExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private Logger logger = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UmsAdminMapper umsAdminMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectByExample(example);
        if (umsAdmins != null && umsAdmins.size() > 0) {
            return umsAdmins.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        umsAdmin.setPassword(passwordEncoder.encode(umsAdminParam.getPassword()));
        umsAdminMapper.insertSelective(umsAdmin);
        logger.debug("新用户注册:" + umsAdmin.toString());
        return umsAdmin;
    }

    @Override
    public List<UmsAdmin> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UmsAdminExample example = new UmsAdminExample();
        //example.setOrderByClause("create_time desc");
        return umsAdminMapper.selectByExample(example);
    }
}
