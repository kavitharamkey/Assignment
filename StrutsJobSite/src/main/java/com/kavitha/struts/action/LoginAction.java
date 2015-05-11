package com.kavitha.struts.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.kavitha.struts.exception.UserDefinedException;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport  implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LoginAction.class);
	private Map<String, Object> sessionMap;

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

	public String execute() {
		
			return SUCCESS;
	}
	
	public void setSession(Map<String, Object> sessionMap) {
		log.info("inside LoginAction.setSession()");
		this.sessionMap = sessionMap;
	}
	
	public String login() throws UserDefinedException {
		log.info("inside LoginAction.execute()");
		log.info("username and password :" + userName + ", "+password);
		
		if (sessionMap.containsKey("userName")) {
			String loggedUserName = (String) sessionMap.get("userName");
			log.info("Already there is a logged User :" +  loggedUserName +", so invalidating the session" );
			 try {
			        ((SessionMap<String, Object>) sessionMap).invalidate();
			    } catch (IllegalStateException e) {
			    	throw new UserDefinedException("New session couldnt be created, please logout and login" + e.getMessage());
			    }
		}
		
		// if no userName stored in the session, 
		// check the entered userName and password
		if(userName==null && password==null){
			log.info("username and password : null");
			throw new UserDefinedException("UserName and Password are required fields");
	    }
		else if("".equals(userName) && "".equals(password)){
			log.info("username and password : empty");
			throw new UserDefinedException("UserName and Password are required fields");
		}
		if (userName.equals("hr") && password.equals("hr")) {
			log.info("username and password :" + userName + ", "+password);
			// add userName to the session
			try {
				 sessionMap.put("userName", userName);
			 } catch (Exception e) {
			    	throw new UserDefinedException("New session couldnt be created, please logout and login" + e.getMessage());
			 }
			
			
			return SUCCESS;	// return welcome page
		}
		
		// in other cases, return login page
		return INPUT;
	}
	
	public String logout() throws UserDefinedException {
		log.info("Inside LoginAction.logout()");
		// remove userName from the session
		if (sessionMap.containsKey("userName")) {
			sessionMap.remove("userName");
		}
		if (sessionMap instanceof org.apache.struts2.dispatcher.SessionMap) {
		    try {
		    	((SessionMap<String, Object>) sessionMap).invalidate();
		    } catch (IllegalStateException e) {
		    	throw new UserDefinedException("Logout request couldnot be completed" + e.getMessage());
		    }
		}
		
		return SUCCESS;
	}


}
