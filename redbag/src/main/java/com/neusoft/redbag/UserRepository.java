package com.neusoft.redbag;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,String> {
}
