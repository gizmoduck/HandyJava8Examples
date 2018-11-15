package com.advance.java;

/**
 * @author achark
 * 
 * dummy employee class used to demonstrate java 8 new features.
 *
 */
public class Employee {
	
	private int empId;
	private String fristName;
	private String lastname;
	private String department;
	private double salary;
	private int age;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee(int empId, String fristName, String lastname, String department, double salary, int age) {
		super();
		this.empId = empId;
		this.fristName = fristName;
		this.lastname = lastname;
		this.department = department;
		this.salary = salary;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [ \nempId=" + empId + ", \nfristName=" + fristName + ", \nlastname=" + lastname + ", \ndepartment="
				+ department + ", \nsalary=" + salary + ", \nage=" + age + "\n]";
	}
	public Employee() {
		super();
	}
	
}
