package com.shop.login.jwt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Payload;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtUtil {

    private static Algorithm algorithm;

    private static final Logger log = Logger.getLogger(JwtUtil.class.getName());
    
    private static Optional<DecodedJWT> jwt;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    private String secret = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";

    public JwtUtil() {
        algorithm = Algorithm.HMAC256(secret);
    }

    public String extractUsername() {
        return jwt.map(Payload::getIssuer).orElse(null);
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String issuer) {
        try {
            
            return Jwts.builder().setClaims(claims).setSubject(issuer).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512) // <-- This can be helpful to you
                .compact();
        } catch (JWTCreationException e) {
            log.log(Level.SEVERE, "Could not create a JWT Token", e);
            return null;
        }
    }

    private Key getSigningKey() {
        byte[] keyBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Boolean validateToken(String token) {
        if (token.equals("null")) {
            return false;
        }
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            jwt = Optional.of(verifier.verify(token));
            return jwt.isPresent() && validatePayload(jwt.get());
        } catch (JWTVerificationException e) {
            log.log(Level.SEVERE, "Could not verify the token", e);
            return false;
        }
    }

    private boolean validatePayload(DecodedJWT jwt) {
        return jwt.getIssuer() != null && jwt.getExpiresAt() != null && jwt.getIssuedAt() != null;
    }
}
