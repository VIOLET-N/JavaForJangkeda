package com.neusoft.view.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);
    @Override
    public List<Food> showFoodList(Integer businessId) {
        FoodDao foodDao = new FoodDaoImpl();
        List<Food> list = foodDao.listFoodByBusinessId(businessId);
        return list;
    }

    @Override
    public void saveFood(Integer businessId) {
        String foodName = "";
        String foodExplain = "";
        Double foodPrice = 0.0;
        System.out.println("输入食物名称：");
        foodName = input.next();
        System.out.println("输入食物简介：");
        foodExplain = input.next();
        System.out.println("输入食物价格（带小数点）：");
        foodPrice = input.nextDouble();
        Food food = new Food(null,foodName,foodExplain,foodPrice,businessId);
        FoodDao foodDao = new FoodDaoImpl();
        foodDao.saveFood(food);
        System.out.println("保存成功！");
    }

    @Override
    public void updateFood(Integer businessId) {
        String foodName = "";
        String foodExplain = "";
        Double foodPrice = 0.0;
        System.out.println("输入修改食物名称：");
        foodName = input.next();
        System.out.println("输入修改食物简介：");
        foodExplain = input.next();
        System.out.println("输入修改食物价格（带小数点）：");
        foodPrice = input.nextDouble();
        Food food = new Food();
    }

    @Override
    public void removeFood(Integer businessId) {

    }
}
