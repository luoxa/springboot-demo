package com.example.demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JsonData;
import com.example.demo.task.AsyncTask;

@RestController
@RequestMapping("/async")
public class AsyncTaskController {

	@Autowired
	private AsyncTask asyncTask;
	
	/**
	 * 功能描述: 异步任务测试1，只异步调用无需返回值
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("/test1")
	public Object test1() throws InterruptedException{
		long begin = System.currentTimeMillis();
		asyncTask.task1();
		asyncTask.task2();
		asyncTask.task3();
		long end = System.currentTimeMillis();
		System.out.println("执行完毕，消耗时间="+ (end-begin));
		return JsonData.buildSuccess() ;
	}
	
	/**
	 * 功能描述: 异步任务测试2，异步调用并获取返回值
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException 
	 */
	@RequestMapping("/test2")
	public Object test2() throws InterruptedException, ExecutionException{
		long begin = System.currentTimeMillis();
		Future<String> task4= asyncTask.task4();
		Future<String> task5= asyncTask.task5();
		Future<String> task6= asyncTask.task6();
		while( !(task4.isDone()&&task5.isDone()&&task6.isDone()) ){ }
		long end = System.currentTimeMillis();
		System.out.println("执行完毕，消耗时间="+ (end-begin));
		System.out.println(task4.get());
		return JsonData.buildSuccess(end-begin) ;
	}
	
}
