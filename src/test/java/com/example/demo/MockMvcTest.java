package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * MockMvc接口测试 
 * API说明：
 * perform():执行RequestBuilder请求
 * addExpect():添加验证规则
 * addReturn():返回MvcResult
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test1() throws Exception{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/get/test1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	}

}
