package com.ijoy.model;

public class Student {
	private String name;
	private String cellPhone;
	
	
	public Student() {
		super();
	}
	public Student(String name, String cellPhone) {
		super();
		this.name = name;
		this.cellPhone = cellPhone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
}
