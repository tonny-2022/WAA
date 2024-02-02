package com.lab3.lab3.service;
import com.lab3.lab3.entity.dto.*;

public interface AuthService {
	    LoginResponse login(LoginRequest loginRequest);
	    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
	
	

}
