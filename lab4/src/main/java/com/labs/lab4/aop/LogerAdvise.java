package com.labs.lab4.aop;

import java.time.LocalDate;
import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.labs.lab4.entity.Loger;
import com.labs.lab4.repo.LogerRepo;

import jakarta.transaction.Transactional;

@Configuration
@Aspect
@Transactional
public class LogerAdvise {
	
	@Autowired
	LogerRepo logerRepo;
	private org.slf4j.Logger  log= LoggerFactory.getLogger(getClass());
	@After("execution(* com.labs.lab4.*.*.*(..))")
	public void logInformationToDB(JoinPoint joinpoint) throws Throwable {
		Loger loger = new Loger();
		LocalDate currDate = LocalDate.now();
		LocalTime currTime= LocalTime.now();
		loger.setOperation(joinpoint.getSignature().getName());
		loger.setDate(currDate.toString());
		loger.setTime(currTime.toString());
		loger.setPrinciple("user2");
		log.info("Around Aspect:{},this  is excuted {},{} ",joinpoint,currDate,currTime);
		logerRepo.save(loger);
	}
	

	
	
	


}
