package com.neusoft.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bag")
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
    @GetMapping("/find/{id}")
    public LuckMoney FindById(@PathVariable("id") Integer id){
//        Optional<LuckMoney> optional = repository.findById(id);
//        if (optional.isPresent()){
//            LuckMoney luckMoney = optional.get();
//            return luckMoney;
//        }
//        return null;
        return repository.findById(id).orElse(null);
    }
    @PutMapping("/put/{id}")
    public LuckMoney put(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer){
        Optional<LuckMoney> optional = repository.findById(id);
        if (optional.isPresent()){
            LuckMoney luckMoney =optional.get();
            luckMoney.setConsumer(consumer);
            return repository.save(luckMoney);
        }
        return null;
    }
}
