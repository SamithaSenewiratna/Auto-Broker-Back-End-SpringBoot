package icet.edu.service.impl;

import icet.edu.entity.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTService {

    //  Secure 512-bit Base64-encoded key for HS512 (64 bytes)
    private static final String SECRET_BASE64 = "q4zXybMg6dEbEKMeOtgnS+Vd4iykY9yXfbLmrqQy6P45Jk9Ox89Lu7wlf4C4o0LBAMV/vJWuO7KzPKu/cB7PIQ==";

    private Key key;

    // Initialize the key after bean creation
    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_BASE64);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    //  Generate a new JWT token for a user
    public String generateToken(UserEntity user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole().name())
                .claim("userId",user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    //  Extract username (subject) from token
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    //  Extract role from token
    public String extractRole(String token) {
        return parseClaims(token).get("role", String.class);
    }

    // Validate the token
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    //  Check if the token is expired
    private boolean isTokenExpired(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }

    // Parse claims safely
    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
