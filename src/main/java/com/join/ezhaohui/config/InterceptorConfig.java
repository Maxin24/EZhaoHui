package com.join.ezhaohui.config;

import com.join.ezhaohui.interceptor.ResponseBeanInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:ljx
 * @Date:2020/4/7
 * @Description:
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration ir=registry.addInterceptor(new ResponseBeanInterceptor());
//        ir.addPathPatterns("/info/*");
    }
}
