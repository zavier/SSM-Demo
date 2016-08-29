package com.springdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.dao.UserMapper;
import com.springdemo.entity.User;

@Controller
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(String username, String password) {
        log.info("username:" + username + "--password:" + password);
        return "index";
    }

    @RequestMapping("/test")
    public String test() {
        User user = new User();

        // 查找所有数据
        System.out.println("初始数据：" + userMapper.getAllUser());
        // 增加
        user.setName("李四");
        user.setAge(13);
        userMapper.addUser(user);
        System.out.println("增加后：" + userMapper.getAllUser());
        // 修改
        user.setId(1);
        user.setName("王五");
        user.setAge(13);
        userMapper.updateUser(user);
        System.out.println("修改后：" + userMapper.getAllUser());
        // 删除
        userMapper.deleteUserById(5);
        System.out.println("删除后：" + userMapper.getAllUser());
        // 查找
        System.out.println("查找id为1的值: " + userMapper.getUserById(1));

        return "test";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(String name) {
        log.info("insert name : " + name);
        User user = new User();
        user.setName(name);
        userMapper.addUser(user);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(String name) {
        log.info("delete name : " + name);
        userMapper.deleteUserByName(name);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        log.info("获取所有用户信息 : " + userList);
        return userList;
    }
}
