package com.mcs.mall.admin.vo;

import com.mcs.mall.admin.bo.AdminUserDetails;
import com.mcs.mall.admin.config.UploadProperty;
import com.mcs.mall.model.UmsAdmin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AdminVOFactory {
    private static String PREFIX;

    @Autowired
    public void setPREFIX(UploadProperty uploadProperty) {
        PREFIX = uploadProperty.getIMG_PREFIX();
    }

    public static AdminVO getAdmin(Authentication authentication) {
        AdminUserDetails adminUserDetails = (AdminUserDetails) authentication.getPrincipal();
        UmsAdmin admin = adminUserDetails.getUmsAdmin();
        return getAdmin(admin);
    }

    public static AdminVO getAdmin(UmsAdmin admin) {
        AdminVO adminVo = new AdminVO();
        BeanUtils.copyProperties(admin, adminVo);
        adminVo.setIcon(PREFIX + adminVo.getIcon());
        return adminVo;
    }
}
