package com.neusoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb","root","123456");

        String sql = "insert into account value (null , 'zhangsan', '1000')";

        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        if(i == 1){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}
