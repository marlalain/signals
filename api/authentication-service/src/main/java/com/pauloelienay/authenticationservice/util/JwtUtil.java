package com.pauloelienay.authenticationservice.util;

import com.pauloelienay.authenticationservice.model.dto.LoginRequest;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtil {
	@Value("${jwt.secret}")
	private String JWT_SECRET;

	@Value("${jwt.expiration}")
	private int JWT_EXPIRATION;

	public String generateToken(LoginRequest user) {
		return Jwts.builder()
			.setSubject(user.getUsername())
			.setIssuedAt(new Date())
			.setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION))
			.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
			.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(cleanToken(token));
			return true;
		} catch (SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims are empty: {}", e.getMessage());
		}

		return false;
	}

	String cleanToken(String token) {
		return token.substring(7);
	}
}
