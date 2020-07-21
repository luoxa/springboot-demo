package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.TestSettings;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
	
	@Value("${test.a}")
	private String a;
	
	@Test
	public void 测试属性注入(){
		Assert.assertEquals("aaa",a);
	}
	
	@Autowired
	private TestSettings testSettings;
	
	@Test
	public void 测试对象注入(){
		System.out.println(testSettings.toString());
		Assert.assertEquals("aaa",testSettings.getA());
	}

}
