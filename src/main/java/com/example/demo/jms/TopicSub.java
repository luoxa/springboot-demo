package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class TopicSub {

	@JmsListener(destination="video.topic",containerFactory="jmsListenerContainerTopic")
	public void receive1(String message){
		System.out.println("receive1接收报文："+message);
	}
	
	@JmsListener(destination="video.topic",containerFactory="jmsListenerContainerTopic")
	public void receive2(String message){
		System.out.println("receive2接收报文："+message);
	}
	
	@JmsListener(destination="video.topic",containerFactory="jmsListenerContainerTopic")
	public void receive3(String message){
		System.out.println("receive3接收报文："+message);
	}
	
}
