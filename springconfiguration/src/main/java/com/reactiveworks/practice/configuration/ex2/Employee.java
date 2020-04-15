package com.reactiveworks.practice.configuration.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	@Value("emp")
	private String ename;
	@Value("12")
	private int eId;
	@Value("100000")
	private int salary;
	@Autowired
	private Address addrs1;

	@Autowired
	private Address addrs2;

	public Employee() {

	}

	public Employee(String ename, int eId, int salary, Address addrs1, Address addrs2) {
		super();
		this.ename = ename;
		this.eId = eId;
		this.salary = salary;
		this.addrs1 = addrs1;
		this.addrs2 = addrs2;
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

	public Address getAddrs1() {
		return addrs1;
	}

	public void setAddrs1(Address addrs1) {
		this.addrs1 = addrs1;
	}

	public Address getAddrs2() {
		return addrs2;
	}

	public void setAddrs2(Address addrs2) {
		this.addrs2 = addrs2;
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", eId=" + eId + ", salary=" + salary + ", addrs1=" + addrs1 + ", addrs2="
				+ addrs2 + "]";
	}

}