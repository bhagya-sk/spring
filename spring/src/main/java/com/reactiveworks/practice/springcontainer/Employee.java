package com.reactiveworks.practice.springcontainer;

import org.apache.log4j.Logger;

public class Employee {

	private static Logger LOGGER_OBJ=Logger.getLogger(Employee.class);
	
	private String ename;
	private int eId;
	private int salary;
	
	public Employee() {
		LOGGER_OBJ.debug("employee object is created");
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", eId=" + eId + ", salary=" + salary + "]";
	}
}
