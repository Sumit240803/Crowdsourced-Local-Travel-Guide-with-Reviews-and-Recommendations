package com.social.travelguide.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
//    private Key secretKey() {
//        try {
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
//            keyGenerator.init(256); // Set key size
//            return keyGenerator.generateKey();
//            // Return the SecretKey directly
//        } catch (Exception e) {
//            throw new IllegalStateException("Could not generate secret key", e);
//        }
//    }
    private static final String jwtSecret = "0e2c999c965ce9a9fa47b6d721bd4f1e4a8dbd1788c622362085e4526697742e";

    // Method to create JWT token
    public String createToken(String username) {
        Key key = new SecretKeySpec(jwtSecret.getBytes(),SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(key) // Use Key object here
                .compact();
    }
    public String getUsernameFromToken(String token){
        Key key = new SecretKeySpec(jwtSecret.getBytes(),SignatureAlgorithm.HS256.getJcaName());
        JwtParser jwtParser= Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public boolean validateToken(String token){
        try{
            Key key = new SecretKeySpec(jwtSecret.getBytes(),SignatureAlgorithm.HS256.getJcaName());
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}