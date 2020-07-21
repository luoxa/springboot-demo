package com.example.demo;

public class ListNode {

	int val;
	
	ListNode next;
	
	ListNode(int x){
		this.val=x;
	}
	

	public ListNode add(int x) {
		this.next = new ListNode(x);
		return next;
	}


	@Override
	public String toString() {
		return this.val + (this.next==null?"":" -> "+this.next.toString());
	}
	
}
