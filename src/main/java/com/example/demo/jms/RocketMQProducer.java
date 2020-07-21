package com.example.demo.jms;

import javax.annotation.PostConstruct;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RocketMQProducer {

	@Value("${apache.rocketmq.producer.producerGroup}")
	private String producerGroup;
	
	@Value("${apache.rocketmq.namesrvAddr}")
	private String namesrvAddr;
	
	private DefaultMQProducer producer;
	
	public DefaultMQProducer getProducer(){
		return this.producer;
	}
	
	@PostConstruct
	public void init(){
		producer = new DefaultMQProducer(producerGroup);
		producer.setNamesrvAddr(namesrvAddr);
		producer.setVipChannelEnabled(false);
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
	}
	
}
