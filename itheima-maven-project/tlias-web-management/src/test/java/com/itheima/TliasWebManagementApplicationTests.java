package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    //生成jwt
    @Test
    void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "john");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")//1.簽名算法
                .setClaims(claims)//2.自定義內容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//設置有效時間為一小時
                .compact();
        System.out.println(jwt);
    }

    //解註JWT令牌
    @Test
    void testParaseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiam9obiIsImlkIjoxLCJleHAiOjE2ODQzMzkxNTB9.EuMbv6ZsYeLZfIA2TqmF20J22579nh5NHLvvHHDBTVA")
                .getBody();
        System.out.println(claims);
    }
}