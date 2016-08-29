package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.User;

public interface UserMapper {
    int addUser(User user);

    User getUserById(int id);

    int updateUser(User user);

    int deleteUserById(int id);

    int deleteUserByName(String name);

    List<User> getAllUser();

}
