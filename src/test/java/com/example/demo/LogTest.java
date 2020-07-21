package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

	private Logger log = LoggerFactory.getLogger(LogTest.class); 
	
	@Test
	public void test(){
		log.debug("这是一个debug日志");
		log.info("这是一个info日志");
		log.warn("这是一个warn日志");
		log.error("这是一个error日志");
	}
	
}
