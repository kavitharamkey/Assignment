package com.kavitha.struts.employeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;


public class DBConnection {

	private static Connection con = null;
	//private static Properties props = new Properties();
	
	public DBConnection(){
	 // do nothing constructor	
	}
	
	public static Connection getConnection() throws ClassNotFoundException, Exception{
		
        try {
        	//FileInputStream fis = new FileInputStream("/DBConnection.properties");
            //props.load(fis);
        	ResourceBundle bundle = ResourceBundle.getBundle("DBConnection") ; 
            // load the Driver Class
            Class.forName(bundle.getString("DB_DRIVER_CLASS"));
 
            // create the connection now
            con = DriverManager.getConnection(bundle.getString("DB_URL"),bundle.getString("DB_USERNAME"),bundle.getString("DB_PASSWORD"));
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
