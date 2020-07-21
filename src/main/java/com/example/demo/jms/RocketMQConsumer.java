package com.example.demo.jms;

import java.io.UnsupportedEncodingException;

import javax.annotation.PostConstruct;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RocketMQConsumer {

	@Value("${apache.rocketmq.consumer.PushConsumer}")
	private String consumerGroup;
	
	@Value("${apache.rocketmq.namesrvAddr}")
	private String namesrvAddr;
	
	@PostConstruct
	public void init(){
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
		consumer.setNamesrvAddr(namesrvAddr);
		
		try {
			consumer.subscribe("testTopic", "*");

			//CONSUME_FROM_LAST_OFFSET  默认策略，从该队列末尾开始消费，跳过历史消息
			//CONSUME_FROM_FIRST_OFFSET 从队列最开始消费，即历史消息（还存在broker的）全部消费一遍
			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
			
			consumer.registerMessageListener((MessageListenerConcurrently)(list, context)->{
				try {
					for(MessageExt messageExt : list){
						System.out.println("messageExt:"+messageExt);
						
						String messageBody = new String(messageExt.getBody(),RemotingHelper.DEFAULT_CHARSET);
						System.out.println("消费响应：msgid="+messageExt.getMsgId()+",msgbody="+messageBody);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return ConsumeConcurrentlyStatus.RECONSUME_LATER;//稍后再试
				}
				
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;//消费成功
			});
			
			consumer.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
