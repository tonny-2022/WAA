package com.lab3.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.User;
import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import com.lab3.lab3.entity.dto.LoginRequest;
import com.lab3.lab3.entity.dto.LoginResponse;
import com.lab3.lab3.entity.dto.RefreshTokenRequest;
import com.lab3.lab3.security.JwtUtil;
import com.lab3.lab3.service.AuthService;


import java.util.Collections;

@Service
//@RequiredArgsConstructor
//@Slf4j
public class AuthServiceImpl implements AuthService {

   @Autowired
    private  AuthenticationManager authenticationManager;
   //@Autowired
    //private  UserDetailsService userDetailsService;
   @Autowired
   private  JwtUtil jwtUtil;

   @Override
   public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
       // Validate the refresh token
       if (jwtUtil.validateRefreshToken(refreshTokenRequest.getRefreshToken())) {
           // Extract username and generate a new access token
           String username = jwtUtil.extractEmail(refreshTokenRequest.getRefreshToken());
           String newAccessToken = jwtUtil.generateAccessToken(username, Collections.emptyList());
           return new LoginResponse(newAccessToken, refreshTokenRequest.getRefreshToken());
       } else {
           // Handle invalid refresh token case
           // Here, throw a custom exception to indicate invalid refresh token
           //throw new InvalidTokenException("Refresh Token is invalid or expired.");
    	   return null;
       }
   }


public LoginResponse login(LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
    );

    User user = (User) authentication.getPrincipal();
    String username = user.getUsername();
    List<String> roles = user.getAuthorities().stream()
            .map(grantedAuthority -> grantedAuthority.getAuthority())
            .collect(Collectors.toList());

    String accessToken = jwtUtil.generateAccessToken(username, roles);
    String refreshToken = jwtUtil.generateRefreshToken(username);

    return new LoginResponse(accessToken, refreshToken);
}


   /* @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

  

	@Override
	public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		  boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
	        if (isRefreshTokenValid) {
	            // TODO (check the expiration of the accessToken when request sent, if the is recent according to
	            //  issue Date, then accept the renewal)
	            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
	            if(isAccessTokenExpired)
	                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
	            else
	                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
	            final String accessToken = jwtUtil.doGenerateToken(  jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
	            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
	            // TODO (OPTIONAL) When to renew the refresh token?
	            return loginResponse;
	        }
	        return new LoginResponse("","");
	}*/
   
   
}