package com.kavitha.struts.action;

import java.sql.Connection;

import org.apache.log4j.Logger;
import com.kavitha.struts.employeeDetails.DBConnection;
import com.kavitha.struts.exception.UserDefinedException;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginAction.class);
	public static Connection con = null;

	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws UserDefinedException{
		log.info("inside LoginAction.execute()");
		if(userName==null && password==null){
			throw new UserDefinedException("UserName and Password are required fields");
	    }
		else if("".equals(userName) && "".equals(password)){
			throw new UserDefinedException("UserName and Password are required fields");
		}

		else{
			try {
				log.debug("Trying to get DB connection");
				con = DBConnection.getConnection(userName, password);
				log.debug("Got DB connection" + con);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
	}
}
