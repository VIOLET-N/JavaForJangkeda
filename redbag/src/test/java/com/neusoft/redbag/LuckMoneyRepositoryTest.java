package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckMoneyRepositoryTest {
    @Autowired
    private LuckMoneyRepository repository;
    @Test
    public void listAll(){
        List<LuckMoney> list = repository.findAll();
        for(LuckMoney luckMoney: list){
            System.out.println(luckMoney);
        }
    }
}
