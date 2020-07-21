package com.example.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sse")
public class ServerSendEventController {

	@RequestMapping(value="/test", produces = "text/event-stream;charset=UTF-8")
	public Object test() throws InterruptedException{
		Thread.sleep(1000);
		String msg = "当前时间"+new Date();
		System.out.println(msg);
		return "data:" + msg +"\n\n";//SSE需要的格式
	}
	
}
