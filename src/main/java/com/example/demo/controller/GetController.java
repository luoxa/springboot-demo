package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

@RestController
@RequestMapping("/get")
public class GetController {
	
	Map<String,Object> result = new HashMap<String,Object>();
	
	/**
	 * 测试GET请求1
	 * @return
	 */
	@RequestMapping(path="/test1", method=RequestMethod.GET)
	public String test1() {
		System.out.println("test1");
		return "test1...";
	}
	
	/**
	 * 测试GET请求2（使用GetMapping简写）
	 * @return
	 */
	@GetMapping("/test2")
	public String test2(){
		return "test2...";
	}
	
	/**
	 * 测试GET请求参数传递及默认值
	 * @return
	 */
	@GetMapping("/test3")
	public Object test3(@RequestParam(defaultValue="0",name="a") int a, int b){
		result.clear();
		result.put("a", a);
		result.put("b", b);
		return result;
	}
	
	/**
	 * 测试restful协议，从路径中获取字段
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@GetMapping("/{city_id}/{user_id}")
	public Object findUser(@PathVariable("city_id") String cityId, 
			@PathVariable("user_id") String userId) {
		result.clear();
		result.put("cityId", cityId);
		result.put("userId", userId);
		return result;
	}
	
	/**
	 * Bean对象传参
	 * 注意：1、要指定http请求头content-type为application/json
	 * 2、使用body传输数据
	 * @param user
	 * @return。
	 */
	@GetMapping("/saveuser")
	public Object savaUser(@RequestBody User user){
		result.clear();
		result.put("user", user);
		return result;
	}

	/**
	 * 获取http请求头部信息
	 * @param accessToken
	 * @param contentType
	 * @return
	 */
	@GetMapping("/headerinfo")
	public Object headerinfo(@RequestHeader("access_token") String accessToken,
			@RequestHeader("Content-Type") String contentType) {
		result.clear();
		result.put("access_token", accessToken);
		result.put("content_type", contentType);
		return result;
	}
	
	/**
	 * 获取request对象传递的参数
	 * @param request
	 * @return
	 */
	@GetMapping("/requestparams")
	public Object requestparams(HttpServletRequest request){
		result.clear();
		result.put("param1", request.getParameter("param1"));
		return result;
	}
}
