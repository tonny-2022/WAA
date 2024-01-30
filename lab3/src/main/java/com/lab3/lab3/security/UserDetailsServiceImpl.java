package com.lab3.lab3.security;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lab3.lab3.entity.Role;
import com.lab3.lab3.entity.User;
import com.lab3.lab3.repo.UserRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	    private final UserRepo userRepo;

	    public UserDetailsServiceImpl(UserRepo userRepo) {
	        this.userRepo = userRepo;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	     
	    	User user = userRepo.findByEmail(username  )
	    	        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
	    	
	        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
	        
	        builder.password(user.getPassword());
	        builder.roles(user.getRoles().stream().map(Role::getRole).toArray(String[]::new));
			return builder.build();
	    }
	
	

}
