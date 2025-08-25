package com.vignesh;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
		private static String DB_URL = "jdbc:mysql://localhost:3306/test";
		private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		private static String DB_USER = "W1_86820_Vignesh";
		public static  String DB_PASS = "manager";
		

		static {
			try{
				Class.forName(DB_DRIVER);
			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);
				
			}
		}
		
		public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		return con;
		}
		
		
		
}
