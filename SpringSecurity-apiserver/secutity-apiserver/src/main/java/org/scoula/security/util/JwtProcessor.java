package org.scoula.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

//JWT를 사용할때 필요한 메서드들을 만들어 놓기 이한 클래스
@Component
@Log4j2
public class JwtProcessor {


    // 토큰 시간 (5분)
    static private  final  long TOKEN_VALID_MILLISECOND = 1000L * 60 * 5;

    private String secretkey = "KB_IT's_YOURS_6기_19회차_JWT수업";
    // 문자열 -> 바이트배열로 변환

    private Key key = Keys.hmacShaKeyFor(secretkey.getBytes((StandardCharsets.UTF_8)));


    // 토큰 만들기
    // subject : 사용자 식별값 (username)
    public String generateToken(String subject, String role){
        return Jwts.builder()
                .setSubject(subject) // 사용자 식별자
                .setIssuedAt(new Date()) // 발급시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILLISECOND))//만료시간
                //.claim("role", role)
                .signWith(key) // 서명
                .compact(); // 문자열 생성
    }

    public String generateTokenByLogin(String subject){
        return Jwts.builder()
                .setSubject(subject) // 사용자 식별자
                .setIssuedAt(new Date()) // 발급시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILLISECOND))//만료시간
                .signWith(key) // 서명
                .compact(); // 문자열 생성
    }
    // 검증
    // Subject -> 사용자 식별자 (사용자 정보중 고유한값)
    // JWT에서 사용자명 추출
    public String getUsername(String token) {
        return Jwts.parserBuilder()           // JWT 파서 빌더 생성
                .setSigningKey(key)               // 서명 검증용 키 설정
                .build()                          // 파서 객체 생성
                .parseClaimsJws(token)            // JWT 토큰 파싱 및 서명 검증
                .getBody()                        // Payload(Claims) 추출
                .getSubject();                    // Subject 클레임에서 사용자명 반환
    }

    // JWT 검증 - 유효 시간과 서명 확인
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)              // 서명 검증 키 설정
                    .build()
                    .parseClaimsJws(token);          // 토큰 파싱 및 검증
            // passeClaimsJws -> 서명(signature) exp(만료일) 검증해준다
            // 사용자정의 Claim -> 개발자가 따로 검증로직을 만들어주어야함
            return true;  // 검증 성공 시 true 반환
        } catch (JwtException | IllegalArgumentException e) {
            log.error("JWT 검증 실패: {}", e.getMessage());
            return false;
        }
    }
}
