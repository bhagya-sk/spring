package com.reactiveworks.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reactiveworks.practice.dao.JdbcDao;
import com.reactiveworks.practice.dao.JdbcDaoUsingDaoSupport;
import com.reactiveworks.practice.model.Employee;

public class Test {

	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("jdbcConfig.xml");

		// JdbcDao
//		JdbcDao jdbcDao = context.getBean("jdbcDao", JdbcDao.class);
//		System.out.println("number of employees: "+jdbcDao.getRecordCount());
//		System.out.println("employee name: "+jdbcDao.getEmployeeName(1));
//		System.out.println("employee details with id=1: "+jdbcDao.getEmployeeById(1));
//		System.out.println("employees: "+jdbcDao.getEmployees().size());
//		jdbcDao.insertEmployee(new Employee(3,"ananya",200000));
		// jdbcDao.deleteEmployee(3);

//		jdbcDao.insertEmployees(new Employee(1,"ananya",10000),new Employee(2,"manas",20000));
//		System.out.println("employees: "+jdbcDao.getEmployees());
//		

		// JdbcDaoUsingDaoSupport
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbcDaoSupportConfig.xml");
		JdbcDaoUsingDaoSupport jdbcDao = context.getBean("jdbcDao", JdbcDaoUsingDaoSupport.class);
		System.out.println("number of employees: " + jdbcDao.getEmployeesCount());
		System.out.println("employees: " + jdbcDao.getEmployees().size());
		jdbcDao.deleteEmployee(3);

		System.out.println("employees: " + jdbcDao.getEmployees());

		((ClassPathXmlApplicationContext) context).close();
	}
}