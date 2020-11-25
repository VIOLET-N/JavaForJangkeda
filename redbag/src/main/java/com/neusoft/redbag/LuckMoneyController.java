package com.neusoft.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LuckMoneyController {
    @Autowired
    private LuckMoneyRepository repository;

    @GetMapping("/list")
    public List<LuckMoney> list(){
        return repository.findAll();
    }
}
