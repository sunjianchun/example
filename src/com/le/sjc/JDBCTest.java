package com.le.sjc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Driver;




/**
 * Created by sunjianchun on 17/1/21.
 */
public class JDBCTest {
    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.deregisterDriver(driver);
            String url = "jdbc:mysql://172.168.10.10:3306/java";
            String user = "test";
            String pass = "123456";
            String sql = "select * from t1";

            Connection co = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            co = DriverManager.getConnection(url,user,pass);
            ps = co.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                System.out.print("id : " + rs.getInt(1) + " name : " + rs.getString(2) + "\n");
            }

            if (rs != null ) {
                try {
                    rs.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null ) {
                try {
                    ps.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (co != null ) {
                try {
                    co.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            //String driver = "com.mysql.jdbc.driver";
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
