package com.kavitha.struts.employeeDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class EmployeeDAO {
	
	private static Statement stmt =null;
	private ResultSet rs = null;
	public List<EmployeeBean> empList = null;
	private static Logger log = Logger.getLogger(EmployeeDAO.class);
	
	
	public EmployeeDAO(Connection con){
	try{
		empList = new ArrayList<EmployeeBean>();
		getEmployeeInfo(con);
	}catch(Exception exp){
		exp.printStackTrace();
	}
	
	}
	

	
	public void getEmployeeInfo(Connection con) throws SQLException {
		try{
			stmt = con.createStatement(); // Step 3
			String query = "select employee_id, first_name,last_name,salary,department_id from employees where salary>4000 order by salary ";
			rs = stmt.executeQuery(query);
			log.debug("Employee Query : \n"+query);
			while (rs.next()) {
				EmployeeBean empbean = new EmployeeBean();
				empbean.setEmpId(rs.getInt("employee_id"));
				empbean.setName(rs.getString("first_name") + rs.getString("last_name"));
				empbean.setSalary(rs.getDouble("salary"));
				empbean.setDeptId(rs.getInt("department_id"));
				empList.add(empbean);			
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
