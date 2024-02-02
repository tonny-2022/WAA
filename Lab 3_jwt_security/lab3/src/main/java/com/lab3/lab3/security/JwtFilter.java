package com.lab3.lab3.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component

public class JwtFilter extends OncePerRequestFilter {
  
	@Autowired
    private  JwtUtil jwtUtil;
	
  //  private  UserDetailsService userDetailsService;


	
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException, java.io.IOException {

            var token = extractTokenFromRequest(request);

            if (token != null && jwtUtil.validateToken(token)) {
            	
            	String userEmail = jwtUtil.extractEmail(token);

                List<SimpleGrantedAuthority> roles = jwtUtil.extractRoles(token).stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userEmail, null, roles);
                SecurityContextHolder.getContext().setAuthentication(auth);
    	
              //  SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(token));
            }

        filterChain.doFilter(request, response);
    }

 
    public String extractTokenFromRequest(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            var token = authorizationHeader.substring(7);
            return token;
        }
        return null;
    }


}
