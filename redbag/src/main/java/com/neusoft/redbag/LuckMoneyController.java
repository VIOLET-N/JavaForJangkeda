package com.neusoft.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LuckMoneyController {
    @Autowired
    private LuckMoneyRepository repository;

    @GetMapping("/list")
    public List<LuckMoney> list(){
        return repository.findAll();
    }
    @PostMapping("/post")
    public LuckMoney postRedBag(@RequestParam(value = "producer", required = true) String producer, @RequestParam(value = "money", required = true) BigDecimal money){
        LuckMoney luckMoney = new LuckMoney();
        luckMoney.setMoney(money);
        luckMoney.setProducer(producer);
        return repository.save(luckMoney);
    }
}
