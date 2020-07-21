package com.example.demo.task;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
@Async
public class AsyncTask {
	
	public void task1() throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("[task1]执行完毕，时间:" + new Date() );
	}
	
	public void task2() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("[task2]执行完毕，时间:" + new Date() );
	}
	
	public void task3() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("[task3]执行完毕，时间:" + new Date() );
	}
	
	public Future<String> task4() throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("[task4]执行完毕，时间:" + new Date() );
		return new AsyncResult<String>("[task4]执行完毕，时间:" + new Date()); 
	}
	
	public Future<String> task5() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("[task5]执行完毕，时间:" + new Date() );
		return new AsyncResult<String>("[task5]执行完毕，时间:" + new Date()); 
	}
	
	public Future<String> task6() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("[task6]执行完毕，时间:" + new Date() );
		return new AsyncResult<String>("[task6]执行完毕，时间:" + new Date()); 
	}

}
