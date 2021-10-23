package com.lzc.user.service.impl;

import com.lzc.user.mapper.UserMapper;
import com.lzc.user.pojo.User;
import com.lzc.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.getUser(user);
    }
}
