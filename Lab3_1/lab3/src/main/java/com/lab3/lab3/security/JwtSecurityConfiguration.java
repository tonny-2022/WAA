package com.lab3.lab3.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

//@Configuration
public class JwtSecurityConfiguration {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("*")
				//.allowedOrigins("http://localhost:8080")
			
				;
			}
		};
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		 //1.ensure that all requests atre authenticated
				return http
						.authorizeHttpRequests(
						   auth->auth.anyRequest().authenticated()
				  ) 
		  // enable basic athentiaction ie pop up in browser
			   .httpBasic(Customizer.withDefaults())	
		  //creates  astateless session
			   .sessionManagement(
				    session->session.sessionCreationPolicy
				    (SessionCreationPolicy.STATELESS))
			   .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
			   
			   .csrf().disable().build();
		
	}
	
	//@Bean
	UserDetailsService userDetailService(DataSource datasource) {
		
		var user=User.withUsername("tonny")
				     .password("123").passwordEncoder(str->passwordEncoder().encode(str))
				     .roles("USER")
				     .build();
		
		var admin=User.withUsername("gigi")
			     .password("123").passwordEncoder(str->passwordEncoder().encode(str))
			     .roles("ADMIN","USER")
			     .build();
		
		var jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	//creating key pair 
	@Bean
	public KeyPair keyPair() {
		try {
			var keyPairGenerator=KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			return keyPairGenerator.generateKeyPair();
			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	//create RSA key object using keypair 
	@Bean
	public RSAKey rsaKey(KeyPair keyPair) {
		
		return new RSAKey
				   .Builder((RSAPublicKey)keyPair.getPublic())
				   .privateKey(keyPair.getPrivate())
				   .keyID(UUID.randomUUID().toString())
				   .build();
	}
	
	
	@Bean
	public JWKSource<SecurityContext> jwkSoruce( RSAKey rsaKey){
		var jwkSet= new JWKSet(rsaKey);
		return (jwkSelector,context)->jwkSelector.select(jwkSet);
	}
	
	@Bean
	public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
		
		return NimbusJwtDecoder
				.withPublicKey(rsaKey.toRSAPublicKey())
				.build();
	}
	
	@Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSoruce) {
		return new NimbusJwtEncoder(jwkSoruce);
		
		
	}

}
