package com.edu.student_management_backend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret; //load từ application.properties

    @Value("${jwt.expiration}")
    private String expirationTime; //load từ application.properties

    @Value("${jwt.rememberExpiration}")
    private String rememberExpirationTime;

    public String generateToken(UserDetails userDetails, boolean remember) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Long expirationTimeLong = Long.parseLong(expirationTime);
        Long rememberExpirationTimeLong = Long.parseLong(rememberExpirationTime);
        final Date createDate = new Date();
        final Date expiration;
        if(remember){
            expiration = new Date(createDate.getTime() + rememberExpirationTimeLong);
        } else {
            expiration = new Date(createDate.getTime() + expirationTimeLong);
        }
        List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

        // Tạo claims và thêm roles
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(expiration)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public String extractUsername(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @SuppressWarnings("unchecked")
    public List<GrantedAuthority> extractAuthorities(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        List<String> roles = (List<String>) claims.get("roles");

        return roles.stream()
                .map(role -> (GrantedAuthority) () -> role)
                .collect(Collectors.toList());
    }
}
