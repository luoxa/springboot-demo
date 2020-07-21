package com.example.demo.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ScheduleTask {
	
	/**
	 * 功能描述: 定时任务，每隔5秒执行一次
	 */
	@Scheduled(fixedRate=5000)
	public void task1(){
		System.out.println("[task1]当前时间: " + new Date() );
	}
	
	/**
	 * 功能描述: 定时任务，延迟5秒再执行一次
	 * @throws InterruptedException 
	 */
	@Scheduled(fixedDelay=5000)
	public void task2() throws InterruptedException{
		System.out.println("[task2]当前时间: " + new Date() );
		Thread.sleep(2000);
	}
	
	/**
	 * 功能描述: 定时任务，使用表达式控制执行频率
	 */
	@Scheduled(cron="*/5 * * * * ?")
	public void task3(){
		System.out.println("[task3]当前时间: " + new Date() );
	}
	
}
