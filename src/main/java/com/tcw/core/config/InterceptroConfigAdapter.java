package com.tcw.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tcw.core.base.LoginInterceptor;

@Configuration
public class InterceptroConfigAdapter extends WebMvcConfigurerAdapter {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
        // 拦截配置
        interceptor.addPathPatterns("/**");
    }
}
