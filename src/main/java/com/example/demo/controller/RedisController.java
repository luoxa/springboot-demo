package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JsonData;
import com.example.demo.entity.User;
import com.example.demo.utils.JsonUtils;
import com.example.demo.utils.RedisClient;

//@RestController
//@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate redisTpl;
	
	@Autowired
	private RedisClient redis;
	
	@RequestMapping("set")
	public Object set(@RequestParam String msg){
		redisTpl.opsForValue().set("msg", msg);
		return JsonData.buildSuccess("ok");
	}
	
	@RequestMapping("get")
	public Object get(){
		String msg = redisTpl.opsForValue().get("msg");
		return JsonData.buildSuccess(msg);
	}
	
	@RequestMapping("saveuser")
	public Object saveUser() {
		User user = new User(101, "张三", "", 0, new Date());
		redis.set("demo:user:101", JsonUtils.Obj2String(user));
		return JsonData.buildSuccess(user);
	}
	
	@RequestMapping("getuser")
	public Object getUser(){
		String data = redis.get("demo:user:101");
		User user = JsonUtils.String2Obj(data, User.class);
		return JsonData.buildSuccess(user);
	}
	
}
