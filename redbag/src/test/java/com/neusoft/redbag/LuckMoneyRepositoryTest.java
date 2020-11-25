package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void getById(){
        Optional<LuckMoney> optional = repository.findById(1);
        System.out.println(optional);
    }

    @Test
    public void save(){
        LuckMoney luckMoney = new LuckMoney();
        luckMoney.setConsumer("李四");
        luckMoney.setMoney(new BigDecimal(11));
        luckMoney.setProducer("张三");
        repository.save(luckMoney);

    }

    @Test
    public void delete(){
        repository.deleteById(1);
    }
}
