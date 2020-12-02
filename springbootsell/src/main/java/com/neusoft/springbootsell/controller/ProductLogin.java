package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductUser;
import com.neusoft.springbootsell.services.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
//import java.util.Map;

@Controller
@RequestMapping("/login/")
public class ProductLogin {
    @Autowired
    private ProductUserService userService;

    @GetMapping("/")
    public ModelAndView login(){
        return new ModelAndView("/product/login");
    }

    @PostMapping("/user")
    public ModelAndView userlogin(@Valid ProductUser form, ModelAndView view){
        ProductUser productUser = userService.findByPhoneAndPwd(form.getProductUserPhone(),form.getProductUserPwd());
        if (productUser != null){
            view.setViewName("redirect:/seller/category/list");
            return view;
        }
        view.setViewName("redirect:/login/");
        return view;
    }
}
