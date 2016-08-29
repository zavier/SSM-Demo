package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dao.UserMapper;
import com.springdemo.entity.User;

@Controller
public class DemoController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/index")
	public String index(){
		User user = new User();
		
		//查找所有数据
		System.out.println("初始数据：" + userMapper.getAllUser());
		//增加
		user.setName("李四");
		user.setAge(13);
		userMapper.addUser(user);
		System.out.println("增加后：" + userMapper.getAllUser());
		//修改
		user.setId(1);
		user.setName("王五");
		user.setAge(13);
		userMapper.updateUser(user);
		System.out.println("修改后：" + userMapper.getAllUser());
		//删除
		userMapper.deleteUserById(5);
		System.out.println("删除后：" + userMapper.getAllUser());
		//查找
		System.out.println("查找id为1的值: " + userMapper.getUserById(1));
		
		return "index";
	}
}
