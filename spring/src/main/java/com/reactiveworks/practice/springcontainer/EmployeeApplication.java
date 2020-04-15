package com.reactiveworks.practice.springcontainer;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class EmployeeApplication {
	private static final Logger LOGGER_OBJ=Logger.getLogger(EmployeeApplication.class);
	
  public static void main(String args[]) {
	 
//	  Employee employeeObj=new Employee();
//	  employeeObj.seteId(11);
//	  employeeObj.setEname("asddf");
//	  employeeObj.setSalary(10000);
	  
	  //using ApplicationContext
	  ApplicationContext  context=new ClassPathXmlApplicationContext("EmployeeBeanConfiguration1.xml");
	  Employee emp1=(Employee) context.getBean("emp1");
	  Employee emp2=(Employee) context.getBean("emp2");
	  LOGGER_OBJ.debug("emp1: "+emp1);
	  LOGGER_OBJ.debug("emp2"+emp2);
	  
	  //using bean factory
	  BeanFactory factory=new XmlBeanFactory(new ClassPathResource("EmployeeBeanConfiguration.xml"));
	  Employee emp3=(Employee) factory.getBean("emp1");
	  Employee emp4=(Employee) factory.getBean("emp2");
	  LOGGER_OBJ.debug("emp3 "+emp3);
	  LOGGER_OBJ.debug("emp4 "+emp4);
  }
}
