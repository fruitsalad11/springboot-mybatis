package com.fruitsalad.demo.service.sys;

import com.fruitsalad.demo.mapper.sys.UserMapper;
import com.fruitsalad.demo.model.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
        userMapper.insert(user);
    }
}
