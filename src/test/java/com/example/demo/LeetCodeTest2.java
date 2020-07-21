package com.example.demo;

import java.util.*;

import org.apache.logging.log4j.util.StringBuilders;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class LeetCodeTest2 {

	
	@Test
	public void 合并两个有序链表() {

		ListNode l1 = new ListNode(1);
		l1.add(2).add(4);
		
		ListNode l2 = new ListNode(1);
		l2.add(3).add(4);
		
		ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while(l1!=null || l2!=null){
            if(l2==null || (l1!=null && l1.val<=l2.val) ){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }

        System.out.println(pre.next);
	}
	
	
	@Test
	public void 括号生成(){
		int n = 3;
		List<String> res = new ArrayList<String>();
		
	}
	
	
	@Test
	public void 合并K个排序链表(){
		
		ListNode l1 = new ListNode(1);
		l1.add(4).add(5);
		
		ListNode l2 = new ListNode(1);
		l2.add(3).add(4);
		
		ListNode l3 = new ListNode(2);
		l3.add(6);
		
		ListNode[] lists = new ListNode[]{l1,l2,l3};
		
		ListNode pre = new ListNode(0);
		ListNode curr = pre;
		while(true){
			int index=-1,min=Integer.MAX_VALUE;
			for(int i=0; i<lists.length; i++){
				if(lists[i]!=null && lists[i].val<min){
					index=i;
					min=lists[i].val;
				}
			}
			
			if(index==-1) break;
			
			curr.next = lists[index];
			curr = curr.next;
			lists[index] = lists[index].next;
		}
		
		System.out.println("res="+pre.next);
	}
	
	@Test
	public void 两两交换链表中的节点(){
		ListNode head = new ListNode(1);
		head.add(2).add(3).add(4);
		
		ListNode pre = new ListNode(0);
        ListNode curr = pre;
        curr.next=head;
        while(head!=null && head.next!=null){
            ListNode temp = head.next;
            head.next = head.next.next;
            curr.next = temp;
            temp.next=head;
            curr=curr.next.next;
            head = head.next;
        }
        
        System.out.println(pre.next);
	}
	
	
	@Test
	public void 删除排序数组中的重复项(){
		int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		
		int temp = nums[0], currIndex=0;
		for(int i=1; i<nums.length; i++){
			if(nums[i]!=temp){
				currIndex++;
				nums[currIndex]=nums[i];
				temp=nums[i];
			}
		}
		System.out.println("res="+(currIndex+1)+",nums="+JSON.toJSONString(nums)); 
	}
	
	@Test
	public void 移除元素(){
		int[] nums = new int[]{0,1,2,2,3,0,4,2};
		int val = 2;
		int currIndex=0;
		for(int i=0; i<nums.length; i++){
			if(nums[i]!=val){
				nums[currIndex]=nums[i];
				currIndex++;
			}
		}
		
		System.out.println("res="+currIndex+",nums="+JSON.toJSONString(nums)); 
	}
	
	@Test
	public void 实现strStr(){
		String haystack = "hello", needle = "ll";
		
		int res = -1;
		if("".equals(needle)) res = 0;
		char[] c1 = haystack.toCharArray(), c2 = needle.toCharArray();
		for(int i=0, max=c1.length-c2.length+1; i<max; i++){
			boolean isMatch = true;
			for(int j=0; j<c2.length; j++){
				if(c1[i+j]!=c2[j]) {
					isMatch = false;
					break;
				}
			}
			if(isMatch){
				res = i;
				break;
			}
		}
		
		System.out.println(res);
	}
	
	@Test
	public void 两数相除(){
		int dividend = -2147483648, divisor = -1;
		
		int res = Math.min(Math.max(dividend/divisor,Integer.MIN_VALUE),Integer.MAX_VALUE);
		
		System.out.println(dividend/divisor);
	}
	
	@Test
	public void 串联所有单词的字串(){
		String s = "barfoothefoobarman";
		String[] words = new String[]{"foo","bar"};
		
		List<Integer> res = new ArrayList<Integer>();
		int len = words[0].length();
		for(int i=0, last=s.length()-len*words.length+1; i<last; i++){
			Boolean isMatch = true;
			int step = 0;
			String[] words1 = new String[words.length];
			System.arraycopy(words, 0, words1, 0, words.length);
			while(isMatch && step<words1.length){
				String curr = s.substring( i+step*len, i+(step+1)*len );
				for(int j=0; j<words1.length; j++){
					if(words1[j].equals(curr)){
						step++;
						words1[j]="";
						break;
					}
					if(j==words1.length-1 && !words1[j].equals(curr)){
						isMatch = false;
						break;
					}
				}
			}
			if(isMatch) res.add(i);
		}
		
		System.out.println(res);
	}
	
	
	@Test
	public void 最长的有效括号(){
		String s="(()";
		
		int res = 0;
		char[] arr = s.toCharArray();
		Deque<Character> dq = new LinkedList<Character>();
		boolean flag=false;
		int curr=0;
        for(int i=0, len=arr.length; i<len; i++ ){
        	char c = arr[i];
        	if(!flag && c=='('){
        		flag = true;
        		dq.offer(')');
        		curr=0;
        	}else if(flag && c=='('){
        		dq.offer(')');
        	}else if(flag && c==')'){
        		Character end = dq.pollLast();
				if(end==null || c!=end){
					flag=false;
					curr=0;
					dq.clear();
				}else{
					curr+=2;
					while(i==len-1 && dq.pollLast()!=null){
						curr-=2;
					}
					res= Math.max(curr,res);
				}
        	}
        }
        
        System.out.println(res);
	}
	
	
	 public static boolean isValidParentheses(String s) {
		boolean res = true;
		Deque<Character> dq = new LinkedList<Character>();
		for(char c : s.toCharArray()){
			if(c=='('){
				dq.offer(')');
			}else if(c==')'){
				Character end = dq.pollLast();
				if(end==null || c!=end){
					res=false;
					break;
				}
			}
		}
		
		if(!dq.isEmpty()) res=false;

		return res;
		
	}
	 
	 @Test
	 public void 有效的数独(){
		 char[][] board = new char[][]{
			new char[] {'8','3','.','.','7','.','.','.','.'},
			new char[] {'6','.','.','1','9','5','.','.','.'},
			new char[] {'.','9','8','.','.','.','.','6','.'},
			new char[] {'8','.','.','.','6','.','.','.','3'},
			new char[] {'4','.','.','8','.','3','.','.','1'},
			new char[] {'7','.','.','.','2','.','.','.','6'},
			new char[] {'.','6','.','.','.','.','2','8','.'},
			new char[] {'.','.','.','4','1','9','.','.','5'},
			new char[] {'.','.','.','.','8','.','.','7','9'}
		 };

		 boolean res=true;
		 for(int i=0; res && i<9; i++){
			 StringBuilder sb = new StringBuilder("");
			 for(int j=0; j<9; j++){
				 char c=board[i][j];
				 if(c!='.' && sb.indexOf(c+"")!=-1){
					 res=false; break;
				 }
				 sb.append(c);
			 }
		 }
		 
		 for(int i=0; res && i<9; i++){
			 StringBuilder sb = new StringBuilder("");
			 for(int j=0; j<9; j++){
				 char c=board[j][i];
				 if(c!='.' && sb.indexOf(c+"")!=-1){
					 res=false; break;
				 }
				 sb.append(c);
			 }
		 }
		 
		 for(int i=0; res && i<9; i+=3){
			 for(int j=0; res && j<9; j+=3){
				 
				 StringBuilder sb = new StringBuilder("");
				 for(int m=0; m<3; m++){
					 for(int n=0; n<3; n++){
						 char c=board[i+m][j+n];
						 if(c!='.' && sb.indexOf(c+"")!=-1){
							 res=false; break;
						 }
						 sb.append(c);
					 }
				 }
				 
			 }
		 }
			 
		 System.out.println(res);
		           
	 }
	 
	@Test
	public void 外观数列() {
		String res = "1";
		int n = 4;
		while (n-- > 1) {
			String temp = "";
			for (int i = 0, count = 1, len = res.length(); i < len; i++) {
				char curr = res.charAt(i);
				if (i == len - 1 || curr != res.charAt(i + 1)) {
					temp += count + "" + curr;
					count = 1;
				} else {
					count++;
				}
			}
			res = temp;
		}
		System.out.println(res);
	}
	 
	 
}
