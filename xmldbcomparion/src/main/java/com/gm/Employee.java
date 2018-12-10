package com.gm;

import java.util.Date;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String title;
	private float salary;
	private String hireDate;
	
	
	
	@Override
	public String toString() {
		return id+" "+ title + ". " + firstName + " " + lastName + " " + salary + " " + hireDate;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public float getSalary() {
		return salary;
	}




	public void setSalary(float salary) {
		this.salary = salary;
	}




	public String getHireDate() {
		return hireDate;
	}




	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}






}
