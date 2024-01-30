package com.lab3.lab3.aop;

import java.time.LocalDate;
import java.time.LocalTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.lab3.lab3.entity.Loger;
import com.lab3.lab3.entity.Post;
import com.lab3.lab3.repo.LogerRepo;
import com.lab3.lab3.repo.PostRepo;

import jakarta.transaction.Transactional;


//@Repository
@Aspect
@Transactional
public class LogerAdvise {
	@Autowired
	PostRepo postRepo;
	@Autowired
	LogerRepo logerRepo;
	private org.slf4j.Logger  log= LoggerFactory.getLogger(getClass());
	@After("execution(* com.lab3.lab3.service.impl.*.*(..))")
	public void logInformationToDB(JoinPoint joinpoint) throws Throwable {
		Loger loger = new Loger();
		LocalDate currDate = LocalDate.now();
		LocalTime currTime= LocalTime.now();
		loger.setOperation(joinpoint.getSignature().getName());
		loger.setDate(currDate.toString());
		loger.setTime(currTime.toString());
		loger.setPrinciple("user1");
		//log.info("Around Aspect:{},this  is excuted {},{} ",joinpoint,currDate,currTime);
		logerRepo.save(loger);
	}
	

	
	
	


}
