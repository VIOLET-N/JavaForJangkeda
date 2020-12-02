package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductUserRepository extends JpaRepository<ProductUser, Integer> {
    ProductUser findByProductUserPhoneAndProductUserPwd(String productPhone, String productUserPwd);
}
