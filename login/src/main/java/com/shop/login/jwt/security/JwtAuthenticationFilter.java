package com.shop.login.jwt.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String requestHeader = request.getHeader("Authorization");

        String token = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {

            token = requestHeader.substring(7);
            String username = jwtUtil.extractUsername();
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
              
                Boolean validateToken = this.jwtUtil.validateToken(token);
                if (validateToken) {
                    authenticate(username);
                } else {
                    logger.info("Validation fails !!");
                }
            }


        } else if(request.getRequestURL().toString().contains("/api/login")) {
            authenticate("");
        }

        allow(request, response, filterChain);


    }

    private void allow(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
			filterChain.doFilter(request, response);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void authenticate(String username) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null,
        new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
}
