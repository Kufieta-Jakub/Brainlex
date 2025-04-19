package com.example.brainlex.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // można trzymać osobno

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 godzina

    // Generowanie tokena
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("brainlex")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    // Odczyt nazwy użytkownika z tokena
    public static String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
