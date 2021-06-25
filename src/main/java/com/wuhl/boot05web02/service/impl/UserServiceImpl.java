package com.wuhl.boot05web02.service.impl;

import com.wuhl.boot05web02.domain.User;
import com.wuhl.boot05web02.mapper.UserMapper;
import com.wuhl.boot05web02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
