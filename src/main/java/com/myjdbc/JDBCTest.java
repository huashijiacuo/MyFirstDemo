package com.myjdbc;

import java.sql.*;

/**
 * Created by shihuashun on 2016/12/7.
 */
public class JDBCTest {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "my_test";
        String passwrod = "";
        String userName = "root";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        String sql = "select * from user";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, userName, passwrod);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("id : " + rs.getInt(1) + " name : "
                        + rs.getString(2) + " password : " + rs.getString(3));
            }

            // 关闭记录集
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭声明
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // 关闭链接对象
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
