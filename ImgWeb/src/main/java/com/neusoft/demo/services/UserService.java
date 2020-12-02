package com.neusoft.demo.services;

import com.neusoft.demo.dataobject.User;

public interface UserService {

    //id查找user
    public User findById(Integer userId);
    //名称查找user
    public User findByName(String userName);
    //保存和更新user
    public User save(User user);
    //账号密码验证
    public User phoneAndPwd(String userPhone, String userPassword);

}
