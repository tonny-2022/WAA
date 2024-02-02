package com.lab3.lab3.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lab3.lab3.entity.Exceptions;


public interface ExceptionRepo extends JpaRepository<Exceptions, Long> {
	
	

}
