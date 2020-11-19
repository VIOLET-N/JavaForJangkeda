package com.neusoft;

import com.neusoft.domain.EMP;

import java.sql.*;

public class JDBCDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb","root","123456");

        String sql = "select * from emp";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int empno = resultSet.getInt(1);
            String eName = resultSet.getString(2);
            String job = resultSet.getString(3);
            int mgr = resultSet.getInt(4);
            Date hiredata = resultSet.getDate(5);
            int sal = resultSet.getInt(6);
            int comm = resultSet.getInt(7);
            int deptno = resultSet.getInt(8);
            EMP emp = new EMP(empno, eName, job, mgr, hiredata, sal, comm, deptno);
            System.out.println(emp);
        }


        //        8、释放资源
        statement.close();
        connection.close();
    }
}
