package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.task.AsyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {

	@Autowired
	private AsyncTask asyncTask;
	
	@Test
	public void test1() throws InterruptedException{
		System.out.println("测试开始");
		asyncTask.task1();
		asyncTask.task2();
		asyncTask.task3();
		System.out.println("测试结束");
	}
	
}
