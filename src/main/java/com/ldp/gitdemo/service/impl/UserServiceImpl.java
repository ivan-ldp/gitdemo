package com.ldp.gitdemo.service.impl;

import com.ldp.gitdemo.dao.UserRepository;
import com.ldp.gitdemo.pojo.User;
import com.ldp.gitdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
