package com.labs.lab4.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;


public class CommonPointcut {
	@Pointcut("execution(* com.labs.lab4.*.*.*(..))")
	public void allOperations () {}
	@Pointcut("execution(* com.labs.lab4.aop.annotations.*.*(..))")
	public void ExecutionTime() {}
	
	

}
