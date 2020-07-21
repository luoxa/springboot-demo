package com.example.demo.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webflux")
public class WebFluxController {

	
	/**
	 * 功能描述: 返回单一对象
	 * @return
	 */
	@GetMapping("/test1")
	public Mono<User> test1(){
		return Mono.justOrEmpty(new User("小明", "", "", 1, new Date()));
	}
	
	/**
	 * 功能描述: 返回多个对象（数组、集合...）
	 * @return
	 */
	@GetMapping("/test2")
	public Flux<User> test2(){
		List<User> list = new ArrayList<User>();
		list.add(new User("小明", "", "", 12, new Date()));
		list.add(new User("小红", "", "", 13, new Date()));
		list.add(new User("小白", "", "", 14, new Date()));
		list.add(new User("小刚", "", "", 15, new Date()));
		return Flux.fromIterable(list);
	}
	
	/**
	 * 功能描述: 逐个对象依次返回
	 * @return
	 */
	@GetMapping(value="/test3",produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<User> test3(){
		List<User> list = new ArrayList<User>();
		list.add(new User("小明", "", "", 12, new Date()));
		list.add(new User("小红", "", "", 13, new Date()));
		list.add(new User("小白", "", "", 14, new Date()));
		list.add(new User("小刚", "", "", 15, new Date()));
		return Flux.fromIterable(list).delayElements(Duration.ofSeconds(1));
	}
	
}
