package com.example.demo.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyWebMvcConfigure implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/get/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
}
