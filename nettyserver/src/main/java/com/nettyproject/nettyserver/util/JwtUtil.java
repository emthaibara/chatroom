package com.nettyproject.nettyserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.nettyproject.nettyserver.enums.TokenClaimEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static com.auth0.jwt.impl.PublicClaims.ISSUER;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/29
 */

public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    public static Boolean verify(String token){
        try {
            JWT.require(Algorithm.HMAC256("salt"))
                    .withIssuer(ISSUER)
                    .build().verify(token);
        }catch (JWTVerificationException e){
            log.error(e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    private static final long EXPIREDTIME = 1000*15L;

    public static String generateToken(String username,String id){
        //key
        String salt = "salt";
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim("id",id)
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis()+EXPIREDTIME))
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(salt));
    }

    public static String getClaim(TokenClaimEnum claimEnum, String token){
        return JWT
                .decode(token)
                .getClaim(claimEnum.getKey())
                .asString();
    }

}

