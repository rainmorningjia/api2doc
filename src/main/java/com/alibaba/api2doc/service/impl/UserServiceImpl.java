package com.alibaba.api2doc.service.impl;

import com.alibaba.api2doc.entity.User;
import com.alibaba.api2doc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void insertUser(User user) {
        System.out.println("添加成功");
    }
}
