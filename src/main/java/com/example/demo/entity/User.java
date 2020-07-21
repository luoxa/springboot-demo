package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private long id;
	
	private String name;
	
	private String phone;
	
	private int age;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
	private Date createTime;

	public User() {
		super();
	}

	public User(long id, String name, String phone, int age, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}
