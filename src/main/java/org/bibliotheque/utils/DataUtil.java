package org.bibliotheque.utils;

import java.sql.Connection;

import java.sql.DriverManager;

public  class DataUtil {
    private static String dbUrl = "jdbc:mysql://localhost:3306/laravel";
    private static String dbUser = "root";
    private static String dbPass = "password";




    private static Connection getConn() {
       try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con= DriverManager.getConnection(dbUrl, dbUser, dbPass);
         if (con!= null){
             Print.log("Connected to the database successfully");
             return con;
         }else {
             Print.log("Failed to connect to database");
         }
       }catch (Exception e){
          Print.log(e.getMessage());
           e.printStackTrace();
           return null;
       }
        return null;
    }
    public static  Connection con = getConn();


}
