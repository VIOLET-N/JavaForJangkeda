package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.ProductUser;
import com.neusoft.springbootsell.repository.ProductUserRepository;
import com.neusoft.springbootsell.services.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUserServiceImpl implements ProductUserService {
    @Autowired
    ProductUserRepository repository;

    @Override
    public ProductUser findByPhoneAndPwd(String phone, String pwd) {
        return repository.findByProductUserPhoneAndProductUserPwd(phone, pwd);
    }
}
