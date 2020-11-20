package com.neusoft.dao.impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.domain.Admin;
import com.neusoft.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDaoImpl implements AdminDao{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public Admin getAdminByNameAndPassword(String Admin, String password) {
        String sql = "select * from admin where adminName=? and password=?";
        Admin admin = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Admin);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                admin = new Admin();
                admin.setAdminId(resultSet.getInt("adminId"));
                admin.setAdminName(resultSet.getString("adminName"));
                admin.setPassword(resultSet.getString("password"));
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(resultSet, preparedStatement, connection);
        }
        return admin;
    }
}
