package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.utils.RedisClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private StringRedisTemplate redisTpl;
	
	@Autowired
	private RedisClient redis;
	
	@Test
	public void testSet1(){
		redisTpl.opsForValue().set("test:a1", "aaa"); 
	}
	
	@Test
	public void testGet1(){
		String result = redisTpl.opsForValue().get("test:a1");
		Assert.assertEquals("aaa", result);
	}
	
	@Test
	public void testSet2(){
		redis.set("test:a2", "aaaa");
	}
	
	@Test
	public void tetGet2(){
		String result = redis.get("test:a2");
		Assert.assertEquals("aaaa", result);
	}
	
}
