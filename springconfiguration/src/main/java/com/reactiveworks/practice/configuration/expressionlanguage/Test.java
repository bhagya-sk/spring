package com.reactiveworks.practice.configuration.expressionlanguage;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
		Practice practice=context.getBean("practice",Practice.class);
		System.out.println(practice);
		
		ExpressionParser parser=new SpelExpressionParser();
		Expression expression=(Expression) parser.parseExpression("'assdfdf'");
		String str= expression.getValue(String.class);
		System.out.println(str);
		((AnnotationConfigApplicationContext)context).close();

	}

}
