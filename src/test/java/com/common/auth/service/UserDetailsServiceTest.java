package com.common.auth.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

/**
 * <b><code>UserDetailsServiceTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/12/12 22:24
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
public class UserDetailsServiceTest {

    @Test
    public void token(){
        String password = "1234";
//        for(int i =0; i<128;i++){
//            password += "1";
//            System.out.println(Keys.password(password.toCharArray()).getAlgorithm());
//        }

        String token;
//        String token = genToken(password);
//        parseToken(token, password);

        // Create a test key suitable for the desired HMAC-SHA algorithm:
        // or HS384 or HS512
        SecretKey key = Jwts.SIG.HS256.key().build();
        // String secretString = Encoders.BASE64.encode(key.getEncoded());
        // SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
        token = genToken(key);
        parseToken(token, key);

        // or RS384, RS512, PS256, etc...
        KeyPair keyPair = Jwts.SIG.RS256.keyPair().build();
        token = genToken(keyPair);
        parseToken(token, keyPair);
    }

    private String genToken(String password){
        return genToken(Jwts.builder().signWith(Keys.password(password.toCharArray())));
    }

    private String genToken(SecretKey key){
        return genToken(Jwts.builder().signWith(key));
    }

    private String genToken(KeyPair keyPair){
        return genToken(Jwts.builder().signWith(keyPair.getPrivate()));
    }

    private String genToken(JwtBuilder jwtBuilder){
        jwtBuilder
                .header()
                .add("aHeaderName", "aHeaderValue")
                .add(new HashMap<>())
                .and()
                .id("888")
                .subject("Rose")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60 * 1000)) // token 过期时间，不设置则不会过期
                .claim("logo", "logo.jpg") //自定 claim
                .claims(new HashMap<>());

        String token = jwtBuilder.compact();
        System.out.println(token);

        String[] split = token.split("\\.");
        System.out.println(Base64.getDecoder().decode(split[0]));
        System.out.println(Base64.getDecoder().decode(split[1]));
        // System.out.println(Base64.getDecoder().decode(split[2]));
        return token;
    }

    public void parseToken(String token, String password){
        System.out.println("------------------------------>parseToken");
        Jws<Claims> jwt = Jwts.parser()
                .verifyWith(Keys.password(password.toCharArray()))
                .build()
                .parseSignedClaims(token);
        System.out.println(jwt);
    }

    public void parseToken(String token, SecretKey key){
        System.out.println("------------------------------>parseToken");
        Jws<Claims> jwt = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
        System.out.println(jwt);
    }

    public void parseToken(String token, KeyPair keyPair){
        System.out.println("------------------------------>parseToken");
        Jws<Claims> jwt = Jwts.parser()
                .verifyWith(keyPair.getPublic()) // <---- publicKey, not privateKey
                .build()
                .parseSignedClaims(token);
        System.out.println(jwt);
    }
}
