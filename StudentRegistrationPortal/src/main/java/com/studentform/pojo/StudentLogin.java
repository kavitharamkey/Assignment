package com.studentform.pojo;

import java.util.Date;


public class StudentLogin implements java.io.Serializable {

	/**
	 *  This is a POJO which stores login information of students in STUDENT_LOGIN table; mapping is handled with annotations
	 */
	private static final long serialVersionUID = 1L;
	//private int studentId;
	private Student student;
	private String username;
	private String password;
	private String createdBy;
	private Date createdDate;

	public StudentLogin() {
	}
 
	public StudentLogin(Student student, String username,String password, String createdBy,Date createdDate) {
		//this.studentId = studentId;
		this.student = student;
		this.username = username;
		this.password = password;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}


	/*public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}*/

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getUsername() {
		return this.username;
	}
    
	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "\n username ="+ username +"\n createdBy ="+ createdBy+"\n createdDate ="+ createdDate;
	}
}