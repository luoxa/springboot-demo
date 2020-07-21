package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {

	@Autowired
	private StringRedisTemplate redisTpl;
	
	public boolean set(String key, String value) {
		try {
			redisTpl.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String get(String key) {
		try {
			return redisTpl.opsForValue().get(key);
		} catch (Exception e) {
			return null;
		}
	}
	
}
