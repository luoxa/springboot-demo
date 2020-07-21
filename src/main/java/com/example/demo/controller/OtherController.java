package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
@RequestMapping("/other")
public class OtherController {
	Map<String,Object> result = new HashMap<String,Object>();

	/**
	 * json序列化测试
	 * 1、别名：@JsonProperty("name")
	 * 2、忽略：@JsonIgnore
	 * 3、非空：@JsonInclude(Include.NON_NULL)
	 * 4、时间格式转换：@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
	 * @return
	 */
	@GetMapping("testjson")
	public Object testjson(){
		result.clear();
		result.put("user1", new User("张三", "000001", "123456", 23, new Date()) );
		result.put("user2", new User("李四", "000001", "123456", null, null) );
		return result;
	}
}
