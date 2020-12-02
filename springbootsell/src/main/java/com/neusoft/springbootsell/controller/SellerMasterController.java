package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.enums.OrderStatusEnum;
import com.neusoft.springbootsell.enums.PayStatusEnum;
import com.neusoft.springbootsell.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/master/")
public class SellerMasterController {
    @Autowired
    MasterService masterService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<OrderMaster> list = masterService.findAll();
        map.put("masterList", list);
        return new ModelAndView("/master/list",map);
    }
}
