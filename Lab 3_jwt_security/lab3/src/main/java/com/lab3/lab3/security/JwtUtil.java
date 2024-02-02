package com.lab3.lab3.security;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Component
public class JwtUtil {

    //@Autowired
    //private UserDetailsService userDetailsService;
   /* private final String secret = "UVs0fleuEW+uivbiIv/n0dSWZtc+byJ/BCdC+1Z76qmAjQ/8607LJZxZVt87ah99Z69TMlyCQLVzdbO5xnFmKw==";
    private final long expiration = 5 * 60 * 60 * 60;
    //     private final long expiration = 5;
    private final long refreshExpiration = 5 * 60 * 60 * 60 * 60;

    // this wil extract a claim from a token, its used in the methods above to get the username and date
    // TODO When this detects the access token is expired it will throw and exception.
    //  handle the exception and do not return null


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles",userDetails.getAuthorities());

        return doGenerateToken(claims, userDetails.getUsername());
    }


    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // Overridden to accommodate the refresh token
    public String doGenerateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getSubject(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println(e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }*/

   /* public Authentication getAuthentication(String token) {
        Claims claims = getAllClaimsFromToken(token);


        UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject()); // LEFT THIS HERE ON PURPOSE
        var authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        return authentication;
    }*/



    /*public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }


    public String getUsernameFromToken(String token) {
        String result = null;
        try {
            result = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
 // Method to extract roles from JWT token
    public List<String> extractRoles(String token) {
       // System.out.println(getClaims(token).get("roles", List.class));
        return getAllClaimsFromToken(token).get("roles", List.class);

    }*/
	
	private final String secretKey = "UVs0fleuEW+uivbiIv/n0dSWZtc+byJ/BCdC+1Z76qmAjQ/8607LJZxZVt87ah99Z69TMlyCQLVzdbO5xnFmKw=="; // Replace with your secret key
    private final long accessTokenValidity = 86400000; // 24 hours
    private final long refreshTokenValidity = 864000000; // 240 hours

    // Method to validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // Log and handle the exception
            //throw new InvalidTokenException("Invalid Access token");
            return false;
        }
    }

    // Method to validate Refresh Token specifically
    public boolean validateRefreshToken(String token)  {
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
            return !claims.containsKey("roles"); // Refresh token does not contain roles
        } catch (JwtException | IllegalArgumentException e) {
            //throw new Exception("Ivalid token");
            return false;
        }
    }

    // Method to extract email from JWT token
    public String extractEmail(String token) {
       // System.out.println(getClaims(token).getSubject());
        return getClaims(token).getSubject();
    }

    // Method to extract roles from JWT token
    public List<String> extractRoles(String token) {
       // System.out.println(getClaims(token).get("roles", List.class));
        return getClaims(token).get("roles", List.class);

    }

    private Claims getClaims(String token) {
//        System.out.println( Jwts.parser()
//                .setSigningKey(secretKey.getBytes())
//                .parseClaimsJws(token)
//                .getBody()
//                .toString()
//        );


        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();


    }

    // Method to generate access token
    public String generateAccessToken(String userEmail, List<String> roles) {
        return generateToken(userEmail, roles, accessTokenValidity);
    }

    // Method to generate refresh token
    public String generateRefreshToken(String userEmail) {
        return generateToken(userEmail, null, refreshTokenValidity);
    }

    private String generateToken(String userEmail, List<String> roles, long durationMillis) {
        Claims claims = Jwts.claims().setSubject(userEmail);
        if (roles != null) {
            claims.put("roles", roles);
        }

        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + durationMillis;
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
    }


    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    // Extract expiration date from token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }



    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Check if the token has expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
	
	
	
}