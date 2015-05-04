package com.kavitha.struts.action;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.kavitha.struts.employeeDetails.EmployeeBean;
import com.kavitha.struts.employeeDetails.EmployeeDAO;
import com.kavitha.struts.exception.UserDefinedException;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(EmployeeAction.class);

	public String execute() throws UserDefinedException{
		log.info("Inside EmployeeAction.execute()");
		log.info("The connection object i am passing is ::"+LoginAction.con);
		EmployeeDAO empdao = new EmployeeDAO(LoginAction.con);
		List<EmployeeBean> empList = empdao.empList;
		log.info("EmployeeAction has got the employee List "+ empList.size());
		if(empList != null){
		ServletActionContext.getRequest().setAttribute("empList", empList);
		return SUCCESS;
		}
		else
			return ERROR;
        
	}
}
