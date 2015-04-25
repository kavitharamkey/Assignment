package employeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetLocationDAO {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String connectionURL = "jdbc:oracle:thin:@localhost:1521/XE";
	//private static Connection con = null;
	private static Statement stmt =null;
	private ResultSet rs = null;
	public List<LocationBean> locationList = null;
	
	
	public GetLocationDAO(Connection con){
		
		try{
			locationList = new ArrayList<LocationBean>();
			getLocationInfo(con);
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
	}
	
	
	
		
	public void getLocationInfo(Connection con) throws SQLException {
		try{
			stmt = con.createStatement(); // Step 3
			rs = stmt.executeQuery("select location_id, state_province,country_id from locations "); 			

			while (rs.next()) {
				LocationBean locbean = new LocationBean();
				locbean.setLocationId(rs.getInt("location_id"));
				locbean.setState(rs.getString("state_province"));
				locbean.setCountry(rs.getString("country_id"));
				locationList.add(locbean);			
			}

		  }catch(SQLException exp){
			exp.printStackTrace();
			throw exp;
		  }finally{
			  if(rs != null){
					rs.close();
				} 
		  }
	}

}
