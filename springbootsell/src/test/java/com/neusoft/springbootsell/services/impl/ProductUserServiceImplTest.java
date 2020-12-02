package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.ProductUser;
import com.neusoft.springbootsell.services.ProductUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductUserServiceImplTest {
    @Autowired
    private ProductUserServiceImpl productUserService;

    @Test
    public void find(){
        ProductUser productUser = productUserService.findByPhoneAndPwd("1","123");
        System.out.println(productUser);
    }
}
