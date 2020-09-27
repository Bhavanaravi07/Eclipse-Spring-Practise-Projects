package com.dxc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PersonAspect {
	
	@Before("execution(String getName())")
	public void getNameAdvice() {
		System.out.println("advice before getter");
	}
	
	@Before("execution(* get*())")
	public void getIdAdvice() {
		System.out.println("advice before getter with wild character");
	}
	
	@Before("setNamePointcut()")
	public void setAdvice() {
		System.out.println("first advice before setter method");
	}
	
	@Before("setNamePointcut()")
	public void setSecondAdvice() {
		System.out.println("second advice before setter method");
	}
	
	@Before("setNamePointcut()")
	public void setThirdAdvice() {
		System.out.println("third advice before setter method");
	}
	
	@Pointcut("execution(public void setName(String))")
	public void setNamePointcut() {}
	
	//demmy method
	//Pointcut declaration
	//this pointcut is to be applied for different join points.
	
	//@Pointcut("within(com.dxc.model.*)")
	//public void allMethodsPointcut() {}
	

}
