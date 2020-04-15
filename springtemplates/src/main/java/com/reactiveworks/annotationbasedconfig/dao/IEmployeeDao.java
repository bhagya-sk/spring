package com.reactiveworks.annotationbasedconfig.dao;

import java.util.List;

import com.reactiveworks.practice.model.Employee;

public interface IEmployeeDao {
	
	public List<Employee> getEmployees();
	public void updateEmployee(int id);
	public void deleteEmployee(int id);
	public void insertEmployee(Employee employee) ;

}
