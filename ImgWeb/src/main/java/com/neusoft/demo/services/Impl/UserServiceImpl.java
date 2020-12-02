package com.neusoft.demo.services.Impl;

import com.neusoft.demo.dataobject.User;
import com.neusoft.demo.repository.UserRepository;
import com.neusoft.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User phoneAndPwd(String userPhone, String userPassword) {

        return userRepository.findByUserPhoneAndUserPassword(userPhone,userPassword);
    }
}
