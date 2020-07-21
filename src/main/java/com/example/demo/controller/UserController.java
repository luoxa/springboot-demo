package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@PostMapping("/add")
	public Object add(@RequestBody User user){
		long id = userService.add(user);
		return id;
	}
	
	@RequestMapping("/findAll")
	public Object findAll(){
		return userMapper.findAll();
	}
	
	@RequestMapping("/findById")
	public Object findById(long id){
		return userMapper.findById(id);
	}
	
	@PostMapping("/update")
	public Object update(@RequestBody User user){
		userMapper.update(user);
		return "update success!";
	}
	
	@PostMapping("/delete")
	public Object delete(long id){
		userMapper.delete(id);
		return "delete success!";
	}
	

}
