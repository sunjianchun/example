package com.le.sjc;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;

import java.sql.*;

/**
 * Created by sunjianchun on 17/1/22.
 */
public class JdbcTest1 {
    public static void main (String[] argv) {
        Connection co = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://172.168.10.10:3306/java";
        String user = "test";
        String pass = "123456";
        String sql = "select * from t1";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection(url,user,pass);
            ps = co.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("ID\t:\t" + rs.getInt(1) + "\t name\t:\t" + rs.getString(2) + "\n");
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }

        if (rs != null) {
            try {

            }catch(Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (ps != null) {
            try {

            }catch(Exception e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (co != null) {
            try {

            }catch(Exception e) {
                e.printStackTrace();
            }
            co = null;
        }
    }

}
