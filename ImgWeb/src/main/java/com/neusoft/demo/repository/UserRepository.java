package com.neusoft.demo.repository;

import com.neusoft.demo.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
    User findByUserPhoneAndUserPassword(String userPhone, String userPwd);
}
