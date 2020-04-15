package com.reactiveworks.practice.dependencyinjection.factorymethod;

public class FactoryMethodDI {
	
		private static final FactoryMethodDI obj=new FactoryMethodDI();  
		private FactoryMethodDI(){System.out.println("private constructor");}  
		public static FactoryMethodDI getFactoryMethodDI(){  
		    System.out.println("factory method ");  
		    return obj;  
		}  
		public void msg(){  
		    System.out.println("hello user");  
		}  
		  
}
