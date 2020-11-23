package com.neusoft.dao.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Food;
import com.neusoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        ArrayList<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId=?";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,businessId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Food food = new Food();
                food.setFoodId(resultSet.getInt(1));
                food.setFoodName(resultSet.getString(2));
                food.setFoodExplain(resultSet.getString(3));
                food.setFoodPrice(resultSet.getDouble(4));
                food.setBusinessId(resultSet.getInt(5));
                list.add(food);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public int saveFood(Food food) {
        int foodId = 0;
        String sql = "insert into food value(null,?,?,?,?)";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                foodId = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,preparedStatement,connection);
        }
        return foodId;
    }

    @Override
    public int updateFood(Food food) {
        int result = 0;
        String sql = "update food set foodName=?,foodExplain=?,foodPrice=? where businessId=? and foodid=?";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());
            preparedStatement.setInt(5,food.getFoodId());
            result = preparedStatement.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(null,preparedStatement,connection);
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId) {
        int result = 0;
        String sql = "delete from food where foodId=?";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,foodId);
            result = preparedStatement.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(null, preparedStatement, connection);
        }
        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId=?";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,foodId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                food = new Food();
                food.setFoodId(resultSet.getInt(1));
                food.setFoodName(resultSet.getString(2));
                food.setFoodExplain(resultSet.getString(3));
                food.setFoodPrice(resultSet.getDouble(4));
                food.setBusinessId(resultSet.getInt(5));
            }
            return food;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,preparedStatement,connection);
        }
        return food;
    }
}
