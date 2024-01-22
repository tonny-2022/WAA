package com.labs.lab4.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lab4.entity.Exceptions;




public interface ExceptionRepo extends JpaRepository<Exceptions, Long> {
	
	

}
