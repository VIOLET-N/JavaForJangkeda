package com.neusoft;

import com.neusoft.domain.EMP;
import com.neusoft.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo04 {
    public static void main(String[] args) throws Exception {
//        List<EMP> EMPList = findAll();
        List<EMP> EMPList = findAll2();
        for (EMP e:EMPList){
            System.out.println(e);
        }
    }
    
    // 调用JDBCUtils 工具类进行操作
    public static List<EMP> findAll2() throws Exception {
        List<EMP> list = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from EMP";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while ( resultSet.next()){
            int EMPno = resultSet.getInt(1);
            String eName = resultSet.getString(2);
            String job = resultSet.getString(3);
            int mgr = resultSet.getInt(4);
            Date hiredata = resultSet.getDate(5);
            int sal = resultSet.getInt(6);
            int comm = resultSet.getInt(7);
            int deptno = resultSet.getInt(8);
            EMP EMP = new EMP(EMPno, eName, job, mgr, hiredata, sal, comm, deptno);
            list.add(EMP);
        }
        JdbcUtil.close(resultSet, statement, connection);
        return list;
    }
}
