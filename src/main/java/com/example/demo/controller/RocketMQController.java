package com.example.demo.controller;


import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JsonData;
import com.example.demo.jms.RocketMQProducer;

@RestController
@RequestMapping("/rocketmq")
public class RocketMQController {

	@Autowired
	private RocketMQProducer rocketMQProducer;
	
	/**
	 * 功能描述:RocketMQ发送消息 
	 * @param msg 消息内容
	 * @param tag 消息二级分类
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sendmsg")
	public Object sendMsg(String msg, String tag) throws Exception{
		//创建消息实例
		Message message = new Message("testTopic", tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET)); 
		//发送消息并接收响应结果
		SendResult result = rocketMQProducer.getProducer().send(message);
		
		System.out.println("发送响应：msgid="+result.getMsgId()+"，状态="+result.getSendStatus());
		return JsonData.buildSuccess();
	}
	
}
