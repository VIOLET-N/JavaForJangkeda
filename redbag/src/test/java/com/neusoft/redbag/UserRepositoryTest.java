package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void save(){
        User user = new User();
        user.setUsername("小小");
        user.setPassword("123456");
        user.setEmail("@qq.com");
        repository.save(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId("8a04aeeb75fea13e0175fea149090000");
        user.setUsername("haha");
        user.setPassword("7777");
        repository.save(user);
    }

    @Test
    public void findById(){
        String id = "8a04aeeb75fea13e0175fea149090000";
        Optional<User> optional = repository.findById(id);
        User user = optional.get();
        System.out.println(user);
    }

    @Test
    public void findAll(){
        List<User> lis = repository.findAll();
        for (User u: lis){
            System.out.println(u);
        }
    }

    @Test
    public void delete(){
        String id = "8a04aeeb75fea13e0175fea149090000";
        repository.deleteById(id);
    }
}
