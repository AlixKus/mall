package com.mcs.mall.admin.component.security;

import com.mcs.mall.admin.bo.AdminUserDetails;
import com.mcs.mall.mapper.UmsAdminLoginLogMapper;
import com.mcs.mall.mapper.UmsAdminMapper;
import com.mcs.mall.model.UmsAdmin;
import com.mcs.mall.model.UmsAdminLoginLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UmsAdminLoginLogMapper logMapper;

    @Autowired
    UmsAdminMapper umsAdminMapper;

    private Logger logger = LoggerFactory.getLogger(AdminAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        /*
        登录成功日志
         */
        Date loginTime = new Date();
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        AdminUserDetails adminUserDetails = (AdminUserDetails) authentication.getPrincipal();
        loginLog.setAdminId(adminUserDetails.getID());
        loginLog.setCreateTime(loginTime);
        loginLog.setIp(request.getRemoteAddr());
        loginLog.setUserAgent(request.getHeader("User-Agent"));
        logMapper.insert(loginLog);
        UmsAdmin umsAdmin = adminUserDetails.getUmsAdmin();
        umsAdmin.setLoginTime(loginTime);
        umsAdminMapper.updateByPrimaryKey(umsAdmin);
        response.sendRedirect("/");
    }

}
