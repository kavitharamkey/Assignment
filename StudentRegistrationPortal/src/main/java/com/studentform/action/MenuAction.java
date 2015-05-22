package com.studentform.action;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;
import com.studentform.exception.UserDefinedException;

public class MenuAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(MenuAction.class);
	
	public String getjobopenings() throws UserDefinedException{
		log.info("Inside MenuAction.getjobopenings()");
		return "job";		
	}
	
	public String getbranchlocations() throws UserDefinedException{
		log.info("Inside MenuAction.getbranchlocations()");
		return "branch";		
	}
	
	public String getcustomerservice() throws UserDefinedException{
		log.info("Inside MenuAction.getcustomerservice()");
		return "service";
		
	}
}