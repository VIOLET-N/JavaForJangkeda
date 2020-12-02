package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.ProductUser;

public interface ProductUserService {
    ProductUser findByPhoneAndPwd(String phone, String pwd);
}
