package com.mvc.employeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String connectionURL = "jdbc:oracle:thin:@localhost:1521/XE";
	private static Connection con = null;
	
	public DBConnection(){
	 // do nothing constructor	
	}
	
	public static Connection getConnection(String dblogin, String dbpasswd) throws ClassNotFoundException, Exception{
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL,dblogin,dbpasswd);
		}catch(ClassNotFoundException exp){
			exp.printStackTrace();
			throw exp;
		}catch(Exception exp){
			exp.printStackTrace();
			throw exp;
		}
		return con;
	}
	public static void closeConnection(Connection con){
		try{
			if(con != null){
				con.close();
			}
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
}
