package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.User;

public interface UserMapper {
	
	@Insert("insert into user(name,phone,age,create_time) values(#{name},#{phone},#{age},#{createTime})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int insert(User user);

	@Select("select * from user")
	@Results({
		@Result(column="create_time", property="createTime")
	})
	List<User> findAll();
	
	@Select("select * from user where id=#{id}")
	@Results({
		@Result(column="create_time", property="createTime")
	})
	User findById(long id);
	
	@Update("update user set name=#{name} where id=#{id} ")
	void update(User user);
	
	@Delete("delete from user where id=#{id}")
	void delete(long id);


}
