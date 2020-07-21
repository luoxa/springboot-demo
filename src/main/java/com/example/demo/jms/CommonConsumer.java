package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class CommonConsumer {

	@JmsListener(destination="common.queue")
	public void receiveQueue(String message){
		System.out.println("CommonConsumer接收报文："+message);
	}
	
}
