package com.diao.myhub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private HandlerInterceptor loginInterceptor;
    @Autowired
    @Qualifier(value = "loginInterceptor")
    public void setLoginInterceptor(HandlerInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }
    private UserInfoFlushInterceptor userInfoFlushInterceptor;
    @Autowired
    public void setUserInfoFlushInterceptor(UserInfoFlushInterceptor userInfoFlushInterceptor) {
        this.userInfoFlushInterceptor = userInfoFlushInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").order(2)
                .excludePathPatterns("/","/index/**","/index","/login/**","/callback","/images/**",
                        "/main","/js/**","/css/**","/fonts/**","/error/**","/swagger-ui/**","/question/**",
                        "/comment/**","/editor.md/**","/uploadFiles/**","/loginError/**");
        registry.addInterceptor(userInfoFlushInterceptor).addPathPatterns("/**").order(1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadFiles/**").addResourceLocations("file:H:/MyWebJars/imgs/");
    }
}
