package com.cybage.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtility {

	public static Connection getConnection() {
   	 try {
   	 Class.forName("com.mysql.cj.jdbc.Driver");
   	 return DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");}
   	 catch(Exception e) {
   		 System.out.println("Error while creating connectin in JDBCUtility"+e);
   	 }
   	 return null;
   	 }
	
}
