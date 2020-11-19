package com.neusoft;

import java.sql.*;

public class JDBCDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkddb","root","123456");

        String sql = "select * from emp";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
//        int i = statement.executeUpdate(sql);
        while(resultSet.next()){
            int EMPNO = resultSet.getInt("EMPNO");
            String ENAME = resultSet.getString("ENAME");
            String JOB = resultSet.getString("JOB");
            int MGR = resultSet.getInt("MGR");
            Date HIREDATE = resultSet.getDate("HIREDATE");
            int SAL = resultSet.getInt("SAL");
            int COMM = resultSet.getInt("COMM");
            int DEPTNO = resultSet.getInt("DEPTNO");
            System.out.println(EMPNO + "\t\t" + ENAME + "\t\t" + JOB +"\t\t"
            + MGR + "\t\t" + HIREDATE + "\t\t" + SAL + "\t\t" + COMM + "\t\t" + DEPTNO);
        }
        statement.close();
        connection.close();
    }
}
