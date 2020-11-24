package com.neusoft.redbag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContraller {
    @GetMapping("/")
    public String sayHello(){
        return "Hello SpringBoot";
    }
}
