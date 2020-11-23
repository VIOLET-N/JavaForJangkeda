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

    }

    @Override
    public void updateFood(Integer businessId) {

    }

    @Override
    public void removeFood(Integer businessId) {

    }
}
