package com.ajay.practice.securityconfiglib.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;

import org.springframework.stereotype.Component;

import com.ajay.practice.securityconfiglib.beans.UserDetails;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtUtil {
	private String secret="AjaysFirstSpringSecurityProject";
	public String extractUsername(String token) throws Exception, UnsupportedJwtException, IllegalArgumentException, Exception {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) throws Exception, UnsupportedJwtException, IllegalArgumentException, Exception {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws Exception, ExpiredJwtException, UnsupportedJwtException, IllegalArgumentException, Exception {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) throws SignatureException, ExpiredJwtException, UnsupportedJwtException, Exception, IllegalArgumentException, Exception {
		return Jwts.parser().setSigningKey(generateHS256Key()).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) throws Exception, IllegalArgumentException, Exception {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userDetails) throws InvalidKeyException, Exception {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUserName());
	}

	@SuppressWarnings("deprecation")
	private String createToken(Map<String, Object> claims, String subject) throws InvalidKeyException, Exception {
//
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//				.signWith(SignatureAlgorithm.HS256,generateHS256Key()).compact();
		return Jwts.builder().setIssuer("Ajay")
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.setIssuedAt(new Date(System.currentTimeMillis())).setSubject(subject).claim("user", subject)
				.claim("role", "developer").signWith(SignatureAlgorithm.HS256, generateHS256Key()).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) throws UnsupportedJwtException, IllegalArgumentException, Exception {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUserName()) && !isTokenExpired(token));
	}
	
	private Key generateHS256Key() throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Cannot generate key");
		}
		byte[] apiKeySecretBytes = digest.digest(secret.getBytes(StandardCharsets.UTF_8));
		System.out.println("Hashed : "+new String(apiKeySecretBytes)+" size: "+apiKeySecretBytes.length);
		apiKeySecretBytes=Arrays.copyOf(apiKeySecretBytes,64);
		System.out.println("Hashed Padded key : "+new String(apiKeySecretBytes)+" size: "+apiKeySecretBytes.length);
		
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		return signingKey;
	}
}
