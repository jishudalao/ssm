package Util;/*
@author 黄大宁Rhinos
@date 2019/1/18 - 13:22
**/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String ip = "localhost";
    static int port = 3306;
    static String database = "springmvc";
    static String encode = "UTF-8";
    static String loginName = "root";
    static String password = "123456";
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC",ip,port,database);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
