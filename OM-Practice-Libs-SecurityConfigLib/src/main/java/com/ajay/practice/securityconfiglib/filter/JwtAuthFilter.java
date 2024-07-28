package com.ajay.practice.securityconfiglib.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ajay.practice.securityconfiglib.Service.CustomUserDetailsService;
import com.ajay.practice.securityconfiglib.util.JwtUtil;

import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token=request.getHeader("authtoken");
		if(token!=null) {
			String userName=null;
		try {
			userName=jwtUtil.extractUsername(token);
		} catch (UnsupportedJwtException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Error during doFilterInternal");
		}
		if(userName!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails details=customUserDetailsService.loadUserByUsername(userName);
			UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(details, null,details.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);	
		}
		else {
			System.out.println("Toke is invalid");
			throw new RuntimeException("Toke is invalid");
		}
		}
		else {
			System.out.println("Toke is null");
		}
		filterChain.doFilter(request, response);
	}

}
