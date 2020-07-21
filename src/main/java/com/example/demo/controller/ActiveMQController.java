package com.example.demo.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JsonData;
import com.example.demo.service.ProducerService;

//@RestController
//@RequestMapping("/activemq")
public class ActiveMQController {
	
	@Autowired
	private ProducerService messageProducerService;

	/**
	 * 功能描述: 发送信息到指定队列
	 * @param message
	 * @return
	 */
	@RequestMapping("/test")
	public Object test(String message){
		Destination destination = new ActiveMQQueue("test.queue");
		messageProducerService.sendMessage(destination, message);
		return JsonData.buildSuccess();
	}
	
	/**
	 * 功能描述: 发送信息到公用队列
	 * @param message
	 * @return
	 */
	@RequestMapping("/common")
	public Object common(String message){
		messageProducerService.sendMessage(message);
		return JsonData.buildSuccess();
	}
	
	/**
	 * 功能描述: 发布消息
	 * @param message
	 * @return
	 */
	@RequestMapping("/topic")
	public Object topic(String message){
		messageProducerService.pushMessage(message);
		return JsonData.buildSuccess();
	}
	
}
