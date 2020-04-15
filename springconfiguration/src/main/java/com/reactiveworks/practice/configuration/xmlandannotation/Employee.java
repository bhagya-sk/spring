package com.reactiveworks.practice.configuration.xmlandannotation;


import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;

public class Employee {

	
	private String ename;
	private int eId;

	@Value("10000") // default value
	private int salary;

	//@Autowired 
	@Inject
	private Address addrs;

	public Employee() {
		System.out.println("employee object is created");
	}

	public Employee(Address addrs) {
		this.addrs = addrs;
	}

	public Employee(String ename, int eId, int salary) {
		super();
		this.ename = ename;
		this.eId = eId;
		this.salary = salary;
	}

	public Employee(String ename, int eId, int salary, Address addrs) {
		super();
		this.ename = ename;
		this.eId = eId;
		this.salary = salary;
		this.addrs = addrs;
	}

	public Address getAddrs() {
		return addrs;
	}

	public void init() {
		System.out.println("inside init method of employee");
	}

	public void destroy() {
		System.out.println("inside destroy method of employee");
	}

	// setter dependency injection
	public void setAddrs(Address addrs) {
		this.addrs = addrs;
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
		return "Employee [ename=" + ename + ", eId=" + eId + ", salary=" + salary + ", addrs=" + addrs + "]";
	}

}
