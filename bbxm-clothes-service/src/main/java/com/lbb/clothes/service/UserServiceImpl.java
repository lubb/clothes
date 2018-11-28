package com.lbb.clothes.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lbb.clothes.business.model.User;
import com.lbb.clothes.business.service.UserService;
import com.lbb.clothes.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取博主信息
     * @return
     */
    @Override
    public User getBlogUser() {
        return userMapper.getBlogUser();
    }
}
