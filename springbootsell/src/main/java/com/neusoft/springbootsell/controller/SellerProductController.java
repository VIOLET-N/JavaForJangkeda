package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.excption.SellException;
import com.neusoft.springbootsell.services.CategotyService;
import com.neusoft.springbootsell.services.ProductService;
import com.neusoft.springbootsell.utils.KeyUtil;
//import jdk.internal.org.jline.keymap.BindingReader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategotyService categotyService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "2") Integer size,
                             Map<String, Object> map){
        PageRequest pageRequest = new PageRequest(page-1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("/index")
    public ModelAndView update(@RequestParam(value = "productId",required = false)String productId,
                               Map<String, Object> map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        List<ProductCategory> categoryList = categotyService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index");
    }

    @PostMapping("/save")
    public ModelAndView update(@Valid ProductInfo from,
                               BindingResult bindingResult,
                               Map<String, Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/product/update");
            return new ModelAndView("common/error");
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(from.getProductId())){
                productInfo = productService.findOne(from.getProductId());
            }else {
                from.setProductId((KeyUtil.genUniqueKey()));
            }

            BeanUtils.copyProperties(from, productInfo);
            productService.save(productInfo);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
