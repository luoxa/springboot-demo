package com.example.demo.service;

import javax.jms.Destination;

public interface ProducerService {

	/**
	 * 功能描述: 发送消息到指定队列
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, final String message);
	
	/**
	 * 功能描述: 发送消息到公共队列
	 * @param message
	 */
	public void sendMessage(final String message);
	
	/**
	 * 功能描述: 发布消息
	 * @param message
	 */
	public void pushMessage(final String message);
	
}
