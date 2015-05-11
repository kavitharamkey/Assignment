package com.kavitha.struts.action;

import java.util.List;

import org.apache.log4j.Logger;
import com.kavitha.struts.employeeDetails.GetLocationDAO;
import com.kavitha.struts.employeeDetails.LocationBean;
import com.kavitha.struts.exception.UserDefinedException;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(MenuAction.class);
	List<LocationBean> locList = null;
	
	public List<LocationBean> getLocList() {
		return locList;
	}
	public String getjobopenings() throws UserDefinedException{
		log.info("Inside MenuAction.getjobopenings()");
		return "job";
		
	}
	public String getbranchlocations() throws UserDefinedException{
		log.info("Inside MenuAction.getbranchlocations()");
		GetLocationDAO locdao = new GetLocationDAO();
		locList = locdao.locationList;
		log.info(" MenuAction.getbranchlocations() has got the location List "+ locList.size());
		if(locList != null){
		//ServletActionContext.getRequest().setAttribute("locList", locList);
		return "branch";
		} else {
			return ERROR;
		}
		
	}
	public String getcustomerservice() throws UserDefinedException{
		log.info("Inside MenuAction.getcustomerservice()");
		return "service";
		
	}
}