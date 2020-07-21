package com.example.demo.utils;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 功能描述: string转obj
	 * @param str
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T String2Obj(String str, Class<T> clazz){
		if(StringUtils.isEmpty(str) || clazz==null){
			return null;
		}
		
		try {
			return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 功能描述: object转string
	 * @param obj
	 * @return
	 */
	public static String Obj2String(Object obj){
		try{
			return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
