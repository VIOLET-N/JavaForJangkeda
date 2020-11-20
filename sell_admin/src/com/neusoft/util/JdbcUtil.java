package com.neusoft.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

    //定义数据资源
    private static DataSource dataSource;

    //初始化静态成员变量
    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);

            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {

        return dataSource.getConnection();
    }

    public static  void close(Statement statement, Connection connection){
        close(null, statement, connection);
    }

    public  static  void close(ResultSet resultSet,Statement statement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
