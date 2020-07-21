package com.example.demo;

import java.util.*;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class LeetCodeWeekMatch1 {

	
	@Test
	public void test1(){
	
		int[] arr = new int[]{10,2,5,3};
		
		boolean res = false;
		for(int i=0,len=arr.length; !res && i<len-1; i++){
			for(int j=i+1; j<len; j++){
				if(arr[i]==2*arr[j] || 2*arr[i]==arr[j]){
					res=true;
					break;
				}
			}
		}
		System.out.println(res);
	}
	
	
	@Test
	public void test2(){
		String s = "leetcode", t = "practice";
		
		int res = 0;
		
		Map<Character,Integer> m1 = new HashMap<Character,Integer>();	
		Map<Character,Integer> m2 = new HashMap<Character,Integer>();	
		
		for(char c : s.toCharArray()){
			m1.put(c, 1+(m1.get(c)==null ? 0 : m1.get(c)) );
		}
		
		for(char c : t.toCharArray()){
			m2.put(c, 1+(m2.get(c)==null ? 0 : m2.get(c)) );
		}
		
		for(Map.Entry<Character, Integer> entry : m1.entrySet()){
			char key = entry.getKey();
			int v1 = entry.getValue();
			int v2 = m2.get(key)==null ? 0 : m2.get(key);
			res += v1<v2 ? 0 : v1-v2;
			System.out.println(key+","+res); 
		}
		
		System.out.println(res);
	}
	
	
	
	@Test
	public void test3(){
		char[][] seats = new char[][]{
			new char[]{'#','.','#','#','.','#'},
			new char[]{'.','#','#','#','#','.'},
			new char[]{'#','.','#','#','.','#'}
		};
		
		int v1=0, v2=0;
		for(int i = seats.length-1; i>0; i--){
			char[] arr = seats[i];
			for(int j=0; j<arr.length; j+=1){
				if(j%2==0 && arr[j]=='.') v1++;
				if(j%2==1 && arr[j]=='.') v2++;
			}
		}
		
		int max = Math.max(v1, v2);
		
		System.out.println(max+","+v1+","+v2);
		
	}
	
	static List<Object[]> list = new ArrayList<Object[]>();
	
	public static void recordTweet(String tweetName, int time) {
	        list.add(new Object[]{tweetName,time});
    }
    
    public static List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    	List<Integer> res = new ArrayList<Integer>();
    	int delta = freq.equals("minute") ? 60 : freq.equals("hour") ? 60*60 : 60*60*24 ;
    	for(int time=startTime; time<endTime; time+= delta){
    		int v = 0;
	    	for(Object[] obj : list){
	    		String tweetName0 = (String) obj[0];
	    		int time0 = (int) obj[1];
	    		if(tweetName0.equals(tweetName) && time0>=time && time0<time+delta) v++;
	    	}
	    	res.add(v);
    	}
        return res;
    }
    
    
    public void test4(){
    	
    }
	
	
}
