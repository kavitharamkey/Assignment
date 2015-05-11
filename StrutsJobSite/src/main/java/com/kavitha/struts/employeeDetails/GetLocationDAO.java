package com.kavitha.struts.employeeDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class GetLocationDAO {
	
	private static Statement stmt =null;
	private ResultSet rs = null;
	public List<LocationBean> locationList = null;
	private static Logger log = Logger.getLogger(GetLocationDAO.class);
	private static Connection con = null;
	
	
	public GetLocationDAO(){
		log.info("GetLocationDAO()");
		try{
			con = DBConnection.getConnection();
			locationList = new ArrayList<LocationBean>();
			getLocationInfo(con);
			DBConnection.closeConnection(con);
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
	}
	
	
	
		
	public void getLocationInfo(Connection con) throws SQLException {
		log.info("getLocationInfo(con)");
		try{
			stmt = con.createStatement(); // Step 3
			rs = stmt.executeQuery("select street_address,city,country_id from locations where state_province IS NOT NULL "); 			

			while (rs.next()) {
				LocationBean locbean = new LocationBean();
				locbean.setStreet(rs.getString("street_address"));
				locbean.setCity(rs.getString("city"));
				locbean.setCountry(rs.getString("country_id"));
				locationList.add(locbean);			
			}

		  }catch(SQLException exp){
			exp.printStackTrace();
			throw exp;
		  }finally{
			  if (stmt != null){
				  stmt.close();
			  }
			  if(rs != null){
					rs.close();
				} 
		  }
	}

}
