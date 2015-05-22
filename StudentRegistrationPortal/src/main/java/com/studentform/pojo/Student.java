package com.studentform.pojo;

import java.util.Date;

public class Student  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int studentId;
	private String firstName;
	private String lastName;
	private Date dob;
	private float gpa;
	private int registeredCourses;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public Student(){
	}
	public Student( String firstName,String lastName,Date dob,float gpa,int registeredCourses,
			        String street, String city,String state, String zipcode){
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
		this.gpa=gpa;
		this.registeredCourses=registeredCourses;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public int getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(int registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
