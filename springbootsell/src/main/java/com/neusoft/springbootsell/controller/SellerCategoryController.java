package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.excption.SellException;
import com.neusoft.springbootsell.services.CategotyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category/")
public class SellerCategoryController {
    @Autowired
    private CategotyService categotyService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<ProductCategory> list = categotyService.findAll();
        map.put("categoryList",list);
        return new ModelAndView("/category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("category/index");
    }

    @PostMapping("/save")
    public ModelAndView index(@Valid ProductCategory from,
                              BindingResult bindingResult,
                              Map<String, Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/category/index");
            return new ModelAndView("common/error");
        }
        ProductCategory productCategory = new ProductCategory(from.getCategoryName(),from.getCategoryType());
        System.out.println(productCategory);
        try {
            categotyService.save(productCategory);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "seller/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
