package com.seven.dubbo.shop.gateway.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.utils
 * @date: 7/3/20
 * @version: 1.0
 */
@Component
public class JWTUtil {
    @Value("${token.secret}")
    private String secret;
    @Value("${token.expire}")
    private Long expire;

    public String getToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(secret+"name"+username);
        return JWT.create().withClaim("username", username)
                .withExpiresAt(new Date(System.currentTimeMillis() + expire * 1000))
                .sign(algorithm);
    }
    public boolean verifyToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getClaim("username").asString();
        Algorithm algorithm = Algorithm.HMAC256(secret+"name"+username);
        if (jwt.getExpiresAt().compareTo(new Date(System.currentTimeMillis())) <= 0) {
            return false;
        }
        try {
            JWT.require(algorithm).build().verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }

        return true;
    }
    public String extractUsername(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("username").asString();
    }
}
