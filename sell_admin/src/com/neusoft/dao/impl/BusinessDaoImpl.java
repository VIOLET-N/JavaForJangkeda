package com.neusoft.dao.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Business> listBusiness(){
        ArrayList<Business> list = new ArrayList<>();
        String sql = "select * from business";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Business business = new Business();
                String businessName = resultSet.getString(3);
                business.setBusinessName(businessName);
                list.add(business);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public int saveBusiness(Business business) {
        int businessId = 0;
        String sql = "insert into business value(null , '123456', ?, ?, ?, ?, ?)";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, business.getPassword());
            preparedStatement.setString(1, business.getBusinessName());
            preparedStatement.setString(1, business.getBusinessAddress());
            preparedStatement.setString(1, business.getBusinessExplain());
            preparedStatement.setDouble(1, business.getStarPrice());
            preparedStatement.setDouble(1, business.getDeliveryPrice());
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                businessId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }
        return businessId;
    }

    @Override
    public int removeBusiness(String businessName) {
        return 0;
    }

    @Override
    public int supdateBusiness(Business business) {
        return 0;
    }

    @Override
    public Business getBusinessById() {
        return null;
    }
}
