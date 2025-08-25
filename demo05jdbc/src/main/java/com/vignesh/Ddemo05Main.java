package com.vignesh;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ddemo05Main {

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
		Scanner sc = new Scanner(System.in);
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL,DB_User,DB_PASS);
			con.setAutoCommit(false);
			System.out.print("eneter the amaount :");
			double amount = sc.nextDouble();
			System.out.print("enetr the account no. : ");
			int id1 = sc.nextInt();
			System.out.println("enetr asccount 2: ");
			int id2  = sc.nextInt();
			
			String sql = "update accounts set balance = balance - ?  where id = ? ";
			PreparedStatement stmt1  = con.prepareStatement(sql);
			stmt1.setDouble(1, amount);
			stmt1.setDouble(2, id1);
			int count1 = stmt1.executeUpdate();
			
			String sql1 = "update accounts set balance = balance + ?  where id = ? ";
			PreparedStatement stmt2  = con.prepareStatement(sql1);
			stmt2.setDouble(1, amount);
			stmt2.setDouble(2, id2);
			int count2 = stmt2.executeUpdate();
			
			if(count1 != 1 || count2 != 1) {
				throw new RuntimeException("Invalid transaction ");
			}else 
					System.out.println("transaction is successful ");
			
//			con.setTransactionIsolation(4);
			con.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			if(con!= null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}  finally {
		try {	if(con != null) {
				con.close();
		}
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
		}
		
	}
}
