package com.neusoft;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb","root","123456");

        String sql = "update account set balance=500 where id=1";

        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        if(i == 1){
            System.out.println("cg");
        }else{
            System.out.println("sb");
        }
    }
}
