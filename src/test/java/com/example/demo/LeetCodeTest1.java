package com.example.demo;

import java.util.*;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class LeetCodeTest1 {
	
	@Test
	public void 无重复字符的最长字串(){
		String s = "pwwkew";
		int res=0;
		int begin=0;
		for(int i=0, len=s.length(); i<len; i++){
			char temp = s.charAt(i);
			int index =s.indexOf(temp, begin);
			if(index!=i){
				begin=index+1;
			}
			res=Math.max(res, i-begin+1);
		}
		System.out.println(res);
	}
	
	@Test
	public void 两数相加() {

		ListNode l1 = new ListNode(2);
		l1.add(4).add(3);
		
		ListNode l2 = new ListNode(5);
		l2.add(6).add(4);
		
		ListNode pre = new ListNode(0);
		ListNode curr = pre;
		int carry = 0;
		while(l1!=null || l2!=null){
			int v1 = l1==null ? 0 : l1.val;
			int v2 = l2==null ? 0 : l2.val;
			
			int sum =v1+v2+carry;
			carry = sum/10;
			sum%=10;
			
			curr.next = new ListNode(sum);
			curr = curr.next;
			
			if(l1!=null)
				l1=l1.next;
			if(l2!=null)
				l2=l2.next;
		}
		
		if(carry==1){
			curr.next = new ListNode(1);
		}
		
		System.out.println(pre.next); 
		
	}
	
	@Test
	public void 寻找两个有序数组中位数(){
		int[] nums1 = new int[]{1,3};
		int[] nums2 = new int[]{2};
		double res;

        //合并成新的有序数组
		int[] nums = new int[nums1.length+nums2.length];
		for(int i=0,j=0; i+j<nums1.length+nums2.length;){
			if(i<nums1.length && (j==nums2.length || nums1[i]<nums2[j]) ){
				nums[i+j]=nums1[i];
				i++;
			}else{
				nums[i+j]=nums2[j];
				j++;
			}
			System.out.println("i="+i+",j="+j);
		}
		
		System.out.println("nums="+JSON.toJSONString(nums));

        //计算新的有序数组中位数
		double half = nums.length/2.0;
		int half2 = (int) Math.round(half);
		if(half2==half){
			res=(nums[half2-1]+nums[half2])/2.0;
		}else{
			res=nums[half2-1];
		}
		System.out.println(res);
	}
	
	@Test
	public void 最长回文子串() {
		String s="cbbd";//babad  cbbd
        int max=0;
        String res="";
        //奇数回文
        for(int i=0, len=s.length(); i<len; i++){
            for(int j=0;i-j>=0&&i+j<len;j++){
            	char left = s.charAt(i-j);
            	char right = s.charAt(i+j);
            	if(left==right){
            		if(2*j+1>max){
            			max=2*j+1;
            			res=s.substring(i-j,i+j+1);
            			System.out.println("max="+max+",res="+res);
            		}
            	}else{
            		break;
            	}
            }
        }
        
        //偶数回文
        for(int i=0, len=s.length(); i<len-1; i++){
        	if(s.charAt(i)!=s.charAt(i+1)) continue;
            for(int j=0;i-j>=0&&i+j+1<len;j++){
            	char left = s.charAt(i-j);
            	char right = s.charAt(i+j+1);
            	if(left==right){
            		if(2*j+2>max){
                    	max=2*j+2;
                    	res=s.substring(i-j,i+j+2);
                    	System.out.println("max="+max+",res="+res);
                    }
            	}else{
            		break;
            		
            	}
            }
        }
        System.out.println("res="+res);
    }
	
	
	@Test
	public void Z形变换(){
		String s="LEETCODEISHIRING";
		int numRows=3;
		
		String res="";
		int num=numRows*2-2;
		for(int i=0; i<numRows; i++){
			String row="";
			for(int j=i, flag=1; j<s.length(); j+=i==0||2*i==num?num:flag*(num-2*i)+(1-flag)*2*i, flag=1-flag){
				row+=s.charAt(j);
			}
			res+=row;
		}
		
		System.out.println(res);
		//LDREOEIIECIHNTSG
	}
	
	@Test
	public void 整数反转(){
		int x = 1534236469;
		long res = 0;
		while(x!=0){
			res=res*10+x%10;
			System.out.println(res);
			x/=10;
		}
		res = Math.min(Math.max(res,Integer.MIN_VALUE),Integer.MAX_VALUE);
		System.out.println(res); 
		
	}
	
	@Test
	public void 字符串转换整数() {
		String str = ".1";
		char[] arr = str.toCharArray();
		long res = 0;
		int zf=1, state = 0;
		for(char c : arr){
			if(state==0 && !(c==' ' || c=='-' || c=='+' || (c>='0'&&c<='9'))){
				break;
			}else if(state==0 && (c=='-' || c=='+')){
				zf=c=='-'?-1:1;
				state=1;
			}else if((state==1||state==2) && c<'0'||c>'9'){
				break;
			}
			else if(c>='0'&&c<='9'){
				res=res*10+c-'0';
				state=2;
				if(zf*res<=Integer.MIN_VALUE || zf*res>=Integer.MAX_VALUE){
					res=zf*Math.min(Math.max(Integer.MIN_VALUE,zf*res),Integer.MAX_VALUE);
					break;
				}
			}
		}
		res*=zf;
		System.out.println(res);
		
	}
	
	
	@Test
	public void 判断整数是否为回文(){
		int x = 121;
		boolean res = true;
        String s = String.valueOf(x);
        for(int i=0, len=s.length(); i<len; i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                res = false;
                break;
            }
        }
        System.out.println(res);
	}
	

	@Test
	public void 判断整数是否为回文2(){
		int x=123;
		
		int x_copy=x, target=0;
		boolean res=false;
		while(x_copy>0){
			target=target*10+x_copy%10;
			x_copy/=10;
		}
		if(x==target) res=true;
		System.out.println(res);
	}

	
	
	/**
	 * 功能描述: 
	 * 状态：未完成
	 */
	@Test
	public void 正则表达式匹配(){
		//String s="aa", p="a"; //false
		//String s="aab", p="c*a*b"; //true
		//String s="mississippi", p="mis*is*p*."; //false
		//String s="aa", p="a*"; //true
		String s="ab", p=".*c"; //false
		
		boolean res=true;
		for(int i=0, j=-1; i<p.length() && res; i++){
			char c1 = p.charAt(i);
			if(j==p.length() && c1!='*'){
				System.out.println("1");
				res=false;
				break;
			}else if(i==p.length()-1 && c1!='*' && s.charAt(j)!=c1){
				res=false;
				break;
			}
			while(++j<s.length()){
				char c2 = s.charAt(j);
				System.out.println("c1="+c1+",c2="+c2+",i="+i+",j="+j);
				if(c1=='.'){
					break;
				}else if(c1=='*'){
					char c3 = i==0?'.':p.charAt(i-1);
					if(c2!=c3 && c3!='.'){
						j--;
						break;
					}
					else{
						continue;
					}
				}else{
					if(c1!=c2){
						if(i<p.length()-2 && p.charAt(i+1)=='*'){
							j--;
							break;
						}
						else{
							res = false;
						}
					}
					break;
				}
			}
			if(i==p.length()-1 && j<s.length()-1) res=false;
		}
		
		System.out.println(res);
	}
	
	
	@Test
	public void 盛最多水的杯子(){
		int[] height = new int[]{1,8,6,2,5,4,8,3,7}; //49
		
		int res=0;
		for(int i=0, len=height.length; i<len; i++){
			for(int j=i+1; j<len; j++){
				int curr = Math.min(height[i],height[j]) * (j-i);
				res = res>curr ? res : curr;
			}
		}
		
		System.out.println(res);
		
	}
	
	
	@Test
	public void 整数转罗马数字(){
		int num = 1994;
		
		String[][] arr=new String[][]{
			new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"},
			new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
			new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
			new String[]{"M","MM","MMM"}
		};
		String res = "";
		for(int i=0; num>0; num/=10,i++){
			int j = num%10-1;
			if(j==-1) continue;
			res = arr[i][j]+res;
			System.out.println("i="+i+",j="+j+",res="+res); 
		}
		
		System.out.println(res);
	}
	
	
	@Test
	public void 罗马数字转整数(){
		
		//String s = "LVIII"; //58
		String s = "MCMXCIV"; //1994
		
		String[][] arr=new String[][]{
			new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"},
			new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
			new String[]{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
			new String[]{"M","MM","MMM"}
		};

        int res=0;
        for(int i=0; i<arr.length; i++){
        	
        	int max=0,target=0;
        	for(int j=arr[i].length-1; j>=0 ; j--){
        		String curr = arr[i][j];
        		if(s.endsWith(curr) && curr.length()>max){
        			max=curr.length();
        			target=j;
        		}
        	}
        	
        	if(max==0) continue; 
        	
        	s= s.substring(0, s.length()-max);
        	res+= (target+1)*Math.round(Math.pow(10, i));
        	System.out.println("res="+res);
        }
        
        System.out.println("res="+res);
        
	}
	
	
	@Test
	public void 最长公共前缀(){
		String[] strs = new String[]{"flower","flow","flight"};//"fl"
		//String[] strs = new String[]{"dog","racecar","car"};//""
		
		String res="";
        for(int i=0; i<strs.length; i++){
            String curr = strs[i];
            if(i==0){
                res=curr;
            }else{
            	int j=0;
                for(; j<res.length()&&j<curr.length() ; j++){
                    if(res.charAt(j)!=curr.charAt(j))
                    break;
                }
                res=res.substring(0,j);
            }
        }
        System.out.println("res="+res);
	}
	
	@Test
	public void 三数之和() {
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		//int[] nums = new int[]{0,0};
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		//排序
		Arrays.sort(nums);
		
		//存入hashmap，便于寻找满足条件元素
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int num :nums){
			Integer v = map.get(num);
			map.put(num,v==null?1:v+1);
		}
		
		for(int i=0, len=nums.length; i<len; i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			for(int j=i+1; j<len; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                
				int target = -nums[i]-nums[j];
				if(target>=nums[j]){//减少重复计算
					Integer v = map.get(target);
					if(v!=null){
						if(v <= (nums[i]==target?1:0)+(nums[j]==target?1:0) ){
							continue;
						}
						res.add(Arrays.asList(new Integer[]{nums[i],nums[j],target}));
					}
				}
			}
		}
		
		System.out.println("总数="+res.size() + ",res="+ res);
	}
	
	@Test
	public void 三数之和2() {
		//int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		//int[] nums = new int[]{0,0,0,0};
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		//排序
		Arrays.sort(nums);
		
		for(int i=0, len=nums.length; i<len-2; i++){
			//与上一元素重复，直接跳过
			int curr = nums[i];
			if(i>0 && curr==nums[i-1]) continue;
			
			int l=i+1, r=len-1;
			while(l<r){
				int rval = nums[r], lval = nums[l];
				if(curr+lval+rval>0 || (r<len-1 && rval==nums[r+1]) )
					r--;
				else if(curr+lval+rval<0 || (l>i+1 && lval==nums[l-1]) )
					l++;
				else{
					//System.out.println("i="+i+",l="+l+",r="+r+",ele="+Arrays.asList(new Integer[]{nums[i],nums[l],nums[r]})); 
					res.add(Arrays.asList(new Integer[]{curr,lval,rval}));
					l++; r--;
				}
			}
			
		}
		
		System.out.println("res.size="+res.size()+",res="+res);
		
	}
	
	@Test
	public void 最接近的三数之和(){
		int[] nums = new int[]{0,2,1,-3};
		int target = 1;
		
		Arrays.sort(nums);
		int res=0;
		for(int i=0, len=nums.length; i<len-2; i++){
			int curr = nums[i]+nums[i+1]+nums[i+2];
			if(i!=0 && Math.abs(curr-target)>=Math.abs(res-target)) break;
			res=curr;
			System.err.println(res);
		}
		
		System.out.println(res);
		
	}
	
	
	@Test
	public void 电话号码字母组合() {

		String digits = "23";
		
		List<String> res = new ArrayList<>();
		String[] arr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		String[] midArr = new String[digits.length()];
		for(int i=0; i<digits.length(); i++){
			String curr = arr[digits.charAt(i)-'2'];
			midArr[i]=curr;
		}
		
		for(int i=0, len=midArr.length; i<Math.pow(10,len) ;i++){
			String ele = ""; boolean flag= true;
			for(int j=len-1; j>=0; j--){
				int index = (int) (i/Math.round(Math.pow(10,len-j-1))%10);
				if(index>=midArr[j].length()){
					flag = false;
					i = (int) ((i+Math.pow(10, len-j))-(i%Math.pow(10, len-j)))-1;
					break;
				}
				ele = midArr[j].charAt(index) + ele;
			}
			if(flag && !ele.equals(""))res.add(ele);
			
		}
		
		System.out.println(res);
		
	}
	
	@Test
	public void 四数之和() {
		 int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		 int target = 0;
		 
		 Arrays.sort(nums);
		 
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 for(int i=0, len=nums.length; i<len; i++){
			 if(i>0 && nums[i]==nums[i-1]) continue;
			 for(int j=i+1; j<len-2; j++){
				 if(j>i+1 && nums[j]==nums[j-1]) continue;
				 int l=j+1, r=len-1, expect=target-nums[i]-nums[j];
				 while(l<r){
					 if(nums[l]+nums[r]<expect || (l>j+1 && nums[l]==nums[l-1])){
						 l++;
					 }else if(nums[l]+nums[r]>expect || (r<len-1 && nums[r]==nums[r+1])){
						 r--;
					 }else{
						 res.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[l],nums[r]}));
						 l++;r--;
					 }
				 }
			 }
		 }
		 
		 System.out.println(res);
		 
	}
	
	@Test
	public void 删除链表的倒数第n个节点(){
		
		ListNode head = new ListNode(1); 
		head.add(2).add(3).add(4).add(5);
		
		int n=2;
		
		int x = 1;
		ListNode curr=head;
		ListNode target=curr;
		while(curr!=null){
			if(curr.next!=null && x>n){
				target=target.next;
			}else if(curr.next==null){
				if(x==n) head = head.next;
				else if(x>n) target.next=target.next.next;
			} 
			x++;
			curr=curr.next;
		}
		
		
		System.out.println(head);
	}
	
	
	@Test
	public void 有效的括号() {

		String s = "]";
		
		boolean res = true;
		Deque<Character> dq = new LinkedList<Character>();
		for(char c : s.toCharArray()){
			if(c=='(' || c=='[' || c=='{'){
				dq.offer(c=='('?')':c=='['?']':'}');
			}else if(c==')' || c==']' || c=='}'){
				Character end = dq.pollLast();
				if(end==null || c!=end){
					res=false;
					break;
				}
			}
		}
		
		if(!dq.isEmpty()) res=false;
		System.out.println(res);
		
	}
	
	
}
