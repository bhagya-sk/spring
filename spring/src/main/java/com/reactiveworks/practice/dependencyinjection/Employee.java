package com.reactiveworks.practice.dependencyinjection;

import org.apache.log4j.Logger;

public class Employee {

	private static Logger LOGGER_OBJ = Logger.getLogger(Employee.class);

	private String ename;
	private int eId;
	private int salary;
	private Address addrs;
	
	
	public Employee(String ename) {
		this.ename=ename;
		
	}

	//constructor dependency injection
	public Employee(Address addr) {
		addrs = addr;
	}

	public Address getAddrs() {
		return addrs;
	}

	//setter dependency injection
	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}

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
		return "Employee [ename=" + ename + ", eId=" + eId + ", salary=" + salary + ", addrs=" + addrs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrs == null) ? 0 : addrs.hashCode());
		result = prime * result + eId;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (addrs == null) {
			if (other.addrs != null)
				return false;
		} else if (!addrs.equals(other.addrs))
			return false;
		if (eId != other.eId)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	

	
}
