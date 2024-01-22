package com.labs.lab4.aop;

import java.time.LocalDate;
import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.labs.lab4.entity.Exceptions;
import com.labs.lab4.repo.ExceptionRepo;



@Configuration
@Aspect
public class ExceptionAdvise {

	@Autowired
	ExceptionRepo exRepo;
	private org.slf4j.Logger  log= LoggerFactory.getLogger(getClass());
	@AfterThrowing(pointcut = "execution(* com.labs.lab4.*.*.*(..))",throwing="exception")
	public void logMethodAfterException(JoinPoint joinpoint,Exception exception) {
		Exceptions exObj = new Exceptions();
		LocalDate currDate = LocalDate.now();
		LocalTime currTime= LocalTime.now();
		exObj.setOperation(joinpoint.getSignature().getName());
		exObj.setDate(currDate.toString());
		exObj.setTime(currTime.toString());
		exObj.setExceptionType(exception.getClass().getName());
		exObj.setPrinciple("user1");
     
		log.info("Around Aspect:{},this  is excuted {},{} ",joinpoint,currDate,currTime);
		exRepo.save(exObj);
     }


}
