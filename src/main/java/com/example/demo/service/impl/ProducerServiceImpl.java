package com.example.demo.service.impl;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private Topic topic;
	
	@Override
	public void sendMessage(Destination destination, final String message) {
		jmsTemplate.convertAndSend(destination,message);
	}

	@Override
	public void sendMessage(String message) {
		jmsTemplate.convertAndSend(queue,message);
	}

	@Override
	public void pushMessage(String message) {
		jmsTemplate.convertAndSend(topic,message);
	}
	

}
