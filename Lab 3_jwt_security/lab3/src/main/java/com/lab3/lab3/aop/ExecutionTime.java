package com.lab3.lab3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExecutionTime {
	
private org.slf4j.Logger  logger= LoggerFactory.getLogger(getClass());
    long startTimeInMs=System.currentTimeMillis();
    @Around("@annotation(com.lab3.lab3.annotations.ExcutionTime)")
	public void showExceutionTime(JoinPoint joinpoint) throws Throwable {
	
		long endTimeInMs=System.currentTimeMillis();
		
		long timeduration=endTimeInMs-startTimeInMs;
		
		logger.info("Around Aspect:{},this  is excuted in {} ms ",joinpoint , timeduration);
		
		
	}
}
