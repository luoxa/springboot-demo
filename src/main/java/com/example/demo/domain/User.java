package com.example.demo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("name")
	private String username;
	
	@JsonIgnore
	private String userid;
	
	@JsonIgnore
	private String password;
	
	@JsonInclude(Include.NON_NULL)
	private Integer age;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
	private Date createTime;
	
	public User() {
		super();
	}
	
	public User(String username, String userid, String password, Integer age, Date createTime) {
		super();
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.age = age;
		this.createTime = createTime;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
