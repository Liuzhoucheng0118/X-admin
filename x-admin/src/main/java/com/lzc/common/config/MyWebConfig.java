package com.lzc.common.config;

import com.lzc.common.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
//        阻截
        registration.addPathPatterns("/**");
//        放行
        registration.excludePathPatterns(
                "/captcha",
                "/user/login",
                "/login",
                "/user/logout",
                "/layui/**",
                "/lib/**",
                "/webjars/**",
                "/js/**",
                "/images/**",
                "/css/**",
                "/api/**"
        );
    }

}
