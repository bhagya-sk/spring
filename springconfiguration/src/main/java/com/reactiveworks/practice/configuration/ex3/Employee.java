package com.reactiveworks.practice.configuration.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emp")
public class Employee {

	@Value("${name}")
	private String ename;
	private int eId;
	@Value("#{1>2?100000:20000}")
	private int salary;

	@Autowired
	private Address addrs;

	public Employee() {
		System.out.println("employee object is created");
	}

	public Employee(Address addrs) {
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

	public Address getAddrs() {
		return addrs;
	}

	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", eId=" + eId + ", salary=" + salary + ", addrs=" + addrs + "]";
	}

}