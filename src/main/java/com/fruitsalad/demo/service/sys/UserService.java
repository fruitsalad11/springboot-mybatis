package com.fruitsalad.demo.service.sys;

import com.fruitsalad.demo.mapper.sys.UserMapper;
import com.fruitsalad.demo.model.sys.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user){
        userMapper.insert(user);
    }

    public List<User> selectList(User user){
        return userMapper.selectList(user);
    }
}
