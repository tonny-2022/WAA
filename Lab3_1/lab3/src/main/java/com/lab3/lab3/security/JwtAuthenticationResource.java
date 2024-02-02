package com.lab3.lab3.security;

import java.time.Instant;
import java.util.stream.Collectors;


import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.core.Authentication;

//@RestController
public class JwtAuthenticationResource {
	private JwtEncoder jwtEncoder;

	public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
		
		this.jwtEncoder=jwtEncoder;
	}
	@Bean
	public JwtResponse authenticate(Authentication autentication) {
		
	//return new JwtResponse(createToken(autentication));
		return null;
	}

	
	private String createToken(Authentication autentication) {
		var claims =JWTClaimsSet.bulder()
				.issuer("self")
				.issuedAt(Instant.now().plusSeconds(60*30))
				.subject(autentication.getName())
				.claim("scope",createScope(autentication))
				.build();
		return JwtEncoder.encode(JwtEncoderParameters.from(claims))
				                 .getTokenValue();
	}
	private String createScope(Authentication autentication) {
	
		return autentication.getAuthorities().stream()
				             .map(a->a.getAuthority())
				             .collect(Collectors.joining(" "));
	}
	record  JwtResponse(String token) {}
	
}
