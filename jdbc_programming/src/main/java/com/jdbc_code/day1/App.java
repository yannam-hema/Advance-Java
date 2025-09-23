package com.jdbc_code.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class App 
{
    public static void main( String[] args )
    {
    	 try {
             // Load MySQL JDBC Driver
             Class.forName("com.mysql.cj.jdbc.Driver");
             System.out.println("Driver is loaded");
             
             // Connect to database
             Connection con = DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/JDBC_DB", "root", "Yannam@300323");
             
             if (con == null) {
                 System.out.println("Connection failed");
             } else {
                 System.out.println("Connection established");
             }
             
             con.close();
         } catch (Exception e) {
             e.printStackTrace();
         }    }
}
