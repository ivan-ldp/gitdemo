package com.ldp.gitdemo.service;

import com.ldp.gitdemo.pojo.User;

public interface UserService {
    User findByUsername(String username);
}
