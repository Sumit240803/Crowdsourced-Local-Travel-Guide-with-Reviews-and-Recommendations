package com.social.travelguide.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private Key secretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            keyGenerator.init(256); // Set key size
            return keyGenerator.generateKey();
            // Return the SecretKey directly
        } catch (Exception e) {
            throw new IllegalStateException("Could not generate secret key", e);
        }
    }

    // Method to create JWT token
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(secretKey(), SignatureAlgorithm.HS256) // Use Key object here
                .compact();
    }
    public String getUsernameFromToken(String token){
        JwtParser jwtParser= Jwts.parserBuilder().setSigningKey(secretKey()).build();
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String token){
        try{
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey()).build();
            jwtParser.parseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}