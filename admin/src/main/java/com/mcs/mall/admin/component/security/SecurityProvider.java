package com.mcs.mall.admin.component.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityProvider implements AuthenticationProvider {
    private Logger logger = LoggerFactory.getLogger(SecurityProvider.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AdminUserDetailsService umsUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        String rawpasswod = (String) token.getCredentials();
        logger.debug("用户尝试登录:" + username + ":" + rawpasswod);
        if (username == null) {
            throw new UsernameNotFoundException("用户名/密码无效");
        }
        UserDetails userDetails = umsUserDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("用户名/密码无效");
        }
        //比较密码
        if (!passwordEncoder.matches(rawpasswod, userDetails.getPassword())) {
            throw new BadCredentialsException("用户名/密码无效");
        }
        logger.debug("用户登录成功:" + username);
        Authentication res = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        return res;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}

