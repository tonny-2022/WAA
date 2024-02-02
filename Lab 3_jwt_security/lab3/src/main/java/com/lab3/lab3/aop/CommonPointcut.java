package com.lab3.lab3.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;


public class CommonPointcut {
	@Pointcut("execution(* com.labs.lab3.*.*.*(..))")
	public void allOperations () {}
	@Pointcut("execution(* com.labs.lab3.aop.Annotations.*.*(..))")
	public void ExecutionTime() {}
	
	

}
