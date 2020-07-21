package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fm")
public class FreemarkerController {

	@RequestMapping("/index")
	public Object index(ModelMap modelMap){
		
		//添加字符串
		modelMap.addAttribute("a","A");
		modelMap.addAttribute("b","B");
		
		//添加map对象
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("msg", "hello");
		modelMap.addAttribute("data", data);
		
		return "index";
	}
	
}
