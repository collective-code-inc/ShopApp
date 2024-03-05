package com.shop.login.jwt.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Payload;
import org.springframework.stereotype.Component;

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
            return JWT.create()
                    .withHeader(claims)
                    .withIssuer(issuer)
                    .withIssuedAt(new Date(System.currentTimeMillis()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            log.log(Level.SEVERE, "Could not create a JWT Token", e);
            return null;
        }
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
