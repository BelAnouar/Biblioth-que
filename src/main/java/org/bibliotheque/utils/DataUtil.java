package org.bibliotheque.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DataUtil {
    public static String dbUrl = "jdbc:mysql://localhost:3306/laravel";
    public static String dbUser = "root";
    public static String dbPass = "password";




    public static Connection getConn() {
       try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con= DriverManager.getConnection(dbUrl, dbUser, dbPass);
         if (con!= null){
             System.out.println("Connected to the database successfully");
             return con;
         }else {
             System.out.println("Failed to connect to database");
         }
       }catch (Exception e){
           System.out.println(e.getMessage());
           e.printStackTrace();
           return null;
       }
        return null;
    }
    public static  Connection con = getConn();

    public static void main(String[] args) {
        System.out.println(DataUtil.getConn());
    }
}
