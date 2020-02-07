package com.fcc.notebook.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";
    
    //创建token
    public static String sign (String username, int userId) {
    	try {
    		Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
    		Map<String, Object> header = new HashMap<>(2);
    		header.put("typ", "JWT");
    		header.put("alg", "HS256");
    		String userid = "" + userId;
    		return JWT.create()
    				.withHeader(header)
    				.withClaim("userName", username)
    				.withClaim("userId",userid)
    				.withExpiresAt(date)
    				.sign(algorithm);
    	}catch(UnsupportedEncodingException e) {
    		return null;
    	}
    }

    //验证token
    public static boolean verify(String token) {
    	try {
    		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
    		JWTVerifier verifier = JWT.require(algorithm)
    				.build();
    		DecodedJWT jwt = verifier.verify(token);
    		return true;
    	} catch (Exception exception) {
    		return false;
    	}
    }
    
    //获取token中包含的用户名
    public static String getUsername(String token) {
    	try {
    		DecodedJWT jwt = JWT.decode(token);
    		return jwt.getClaim("userName").asString();
    	}catch (JWTDecodeException e) {
    		return null;
    	}
    }
    
    //获取token中包含的用户ID
    public static String getUserId(String token) {
    	try {
    		DecodedJWT jwt = JWT.decode(token);
    		return jwt.getClaim("userId").asString();
    	} catch (JWTDecodeException e) {
    		return null;
    	}
    }
}