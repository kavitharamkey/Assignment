package com.kavitha.struts.exception;

public class UserDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDefinedException(String errMsg){
		super(errMsg);
	}
}
