package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class TestConsumer {

	@JmsListener(destination="test.queue")
	public void receiveQueue(String message){
		System.out.println("TestConsumer接收报文："+message);
	}
	
}
