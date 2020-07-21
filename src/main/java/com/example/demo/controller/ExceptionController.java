package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MyException;

@RestController
@RequestMapping("/ext")
public class ExceptionController {

	@RequestMapping("/test1")
	public Object test1(){
		int a = 1/0;
		return a;
	}
	
	@RequestMapping("/test2")
	public Object test2(){
		throw new MyException(500, "服务器繁忙");
	}
}
