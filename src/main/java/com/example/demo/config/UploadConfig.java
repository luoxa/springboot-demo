package com.example.demo.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadConfig {

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//设置单个文件最大值
		factory.setMaxFileSize("1500KB");//KB,MB
		//设置总上传数据最大值
		factory.setMaxRequestSize("1024MB");//KB,MB
		return factory.createMultipartConfig(); 
	}
}
