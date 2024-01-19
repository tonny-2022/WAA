package com.labs.lab2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.lab2.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
