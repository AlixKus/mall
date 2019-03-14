package com.mcs.mall.admin.component.security;

import com.mcs.mall.admin.bo.AdminUserDetails;
import com.mcs.mall.admin.service.UmsAdminService;
import com.mcs.mall.model.UmsAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(AdminUserDetailsService.class);

    @Autowired
    UmsAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin admin = adminService.getAdminByUsername(username);
        if (admin != null) {
            return new AdminUserDetails(admin);
        }
        throw new UsernameNotFoundException("用户名不存在");
    }

}
