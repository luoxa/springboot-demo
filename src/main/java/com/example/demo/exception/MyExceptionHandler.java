package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Object handlerException(Exception e, HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 100);
		map.put("url", request.getRequestURL());
		map.put("msg", e.getMessage());
		return map;
	}
	
	@ExceptionHandler(value=MyException.class)
	public Object handlerException(MyException e, HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("code", e.getCode());
		modelAndView.addObject("msg", e.getMsg());
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
}
