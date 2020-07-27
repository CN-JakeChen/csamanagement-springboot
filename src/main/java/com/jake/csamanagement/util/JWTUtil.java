package com.jake.csamanagement.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtil {
    // 过期时间 24 小时
//    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    private static final long EXPIRE_TIME = 120 * 60 * 1000;//token2小时后过期
    private static final long REFRESH_EXPIRE_TIME=60 * 24 * 60 * 1000;//refreshtoken一天后过期
    // 密钥
    private static final String SECRET = "SHIRO+JWT";
    private static final String SECRET2 = "SHIRO+JWT+REFRESH";
    public static String createToken(String username) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                //到期时间
                .withExpiresAt(date)
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(algorithm);
    }

    public static String createRefreshToken(String username) {
        Date date = new Date(System.currentTimeMillis() + REFRESH_EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET2);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                //到期时间
                .withExpiresAt(date)
                //创建一个新的JWT，并使用给定的算法进行标记
                .sign(algorithm);
    }

    public static int verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return 1;
        } catch (TokenExpiredException e) {
            return 2;
        }catch (Exception e){
            return 3;
        }
    }

    public static int verifyRefresh(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET2);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            //验证 token
            verifier.verify(token);
            return 1;
        } catch (TokenExpiredException e) {
            return 2;
        }catch (Exception e){
            return 3;
        }
    }
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

}
