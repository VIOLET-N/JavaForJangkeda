package com.neusoft.dao.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress){
        ArrayList<Business> list = new ArrayList<>();
//        String sql = "";
        StringBuffer stringBuffer = new StringBuffer("select * from business where 1=1");
        if(businessName != null && !businessName.equals("")){
            stringBuffer.append("and businessName like '%"+businessAddress+"%'");
        }
        if (businessAddress != null && businessAddress.equals("")){
            stringBuffer.append("and businessAddress like '%"+businessAddress+"%'");
        }
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(stringBuffer.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Business business = new Business();
                String businessName1 = resultSet.getString(3);
                business.setBusinessName(businessName1);
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
    public int removeBusiness(int businessId) {
        String sql = "delete from business where businessId=?";
        int result = 0;
        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, businessId);
            result = preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            result = 0;
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtil.close(preparedStatement, connection);
        }
        return result;
    }

    @Override
    public int supdateBusiness(Business business) {
        int result = 0;
        String sql = "update business set businessName=?,businessAddress=?," +
                "businessExplain=?,starPrice=?,deliveryPrice=? where businessId=?";
        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,business.getBusinessName());
            preparedStatement.setString(2,business.getBusinessAddress());
            preparedStatement.setString(3,business.getBusinessExplain());
            preparedStatement.setDouble(4,business.getStarPrice());
            preparedStatement.setDouble(5,business.getDeliveryPrice());
            preparedStatement.setInt(6,business.getBusinessId());
            result = preparedStatement.executeUpdate();
            return result;
        } catch (Exception e) {
            result = 0;
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtil.close(preparedStatement, connection);
        }
        return result;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        String sql = "select * from business where businessId=?";
        Business business = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,businessId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                business = new Business();
                business.setBusinessId(resultSet.getInt("businessId"));
                business.setBusinessName(resultSet.getString("businessName"));
                business.setBusinessAddress(resultSet.getString("businessAddress"));
                business.setBusinessExplain(resultSet.getString("businessExplain"));
                business.setStarPrice(resultSet.getDouble("starPrice"));
                business.setDeliveryPrice(resultSet.getDouble("deliveryPrice"));
                return business;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return business;
    }

    @Override
    public Business getBusinessByIdAndPassword(Integer businessId, String password) {
        Business business = null;
        String sql = "select * from business where businessId = ? and password = ? ";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, businessId);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                business = new Business();
                business.setBusinessId(resultSet.getInt("businessId"));
                business.setPassword(resultSet.getString("password"));
                business.setBusinessName(resultSet.getString("businessName"));
                business.setBusinessAddress(resultSet.getString("businessAddress"));
                business.setBusinessExplain(resultSet.getString("businessExplain"));
                business.setStarPrice(resultSet.getDouble("starPrice"));
                business.setDeliveryPrice(resultSet.getDouble("deliveryPrice"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet,preparedStatement,connection);
        }

        return business;
    }

    @Override
    public int updateBusinessPassword(Integer businessId,String password) {
        int res = 0;
        String sql = "update business set password = ? where businessId = ?";
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, businessId);
            res = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet, preparedStatement,null);
        }
        return res;
    }
}
