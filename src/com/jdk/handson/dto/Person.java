package com.jdk.handson.dto;

public class Person {

	private String pName;
	private Double pSalary;
	private String pCourse;
	private String pGender;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Double getpSalary() {
		return pSalary;
	}

	public void setpSalary(Double pSalary) {
		this.pSalary = pSalary;
	}

	public String getpCourse() {
		return pCourse;
	}

	public void setpCourse(String pCourse) {
		this.pCourse = pCourse;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public Person(String pName, Double pSalary, String pCourse, String pGender) {
		super();
		this.pName = pName;
		this.pSalary = pSalary;
		this.pCourse = pCourse;
		this.pGender = pGender;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [pName=" + pName + ", pSalary=" + pSalary + ", pCourse=" + pCourse + ", pGender=" + pGender
				+ "]";
	}

}
