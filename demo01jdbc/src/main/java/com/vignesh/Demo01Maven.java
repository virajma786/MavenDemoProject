package com.vignesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01Maven {
			
			public static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
			public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
			public static final String DB_User = "W1_86820_Vignesh";
			public static final String DB_PASS = "manager";
			
			
			
			static {
				try {
					Class.forName(DB_Driver);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
					System.exit(1);
				}
			}
			public static void main(String[] args) {
				try {Connection con = DriverManager.getConnection(DB_URL, DB_User, DB_PASS);
					try(Statement stmt = con.createStatement()){
						String sql = "select * from students"; 
					    try(ResultSet rs = 	stmt.executeQuery(sql)){
					    	while(rs.next()) {
					    		int roll = rs.getInt("rollno");
					    		String name = rs.getString("name");
					    		Double marks = rs.getDouble("marks");
					    		System.out.println(roll +", "  + name + ", "+ marks);
					    	}	
					}// rs will be closed 
				}// statment will be closed 	
			}// con will be closed 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
}
