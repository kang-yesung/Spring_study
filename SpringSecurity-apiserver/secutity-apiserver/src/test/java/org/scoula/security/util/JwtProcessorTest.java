package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class JwtProcessorTest {

    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {

        //테스트용 username
        String username = "user0";
        String role = "ROLE_ADMIN";

        String token = jwtProcessor.generateToken(username, role);

        log.info("생성된 토큰 : {}", token);
    }

    @Test
    void validateToken() {
        String username = "testuser";
        String role = "ROLE_ADMIN";

        //토큰 생성
        String token = jwtProcessor.generateToken(username, role);
        log.info("생성된 토큰 : {}", token);

        boolean isValid = jwtProcessor.validateToken(token);

        log.info("검증결과(true/false) : {}", isValid);
        assertTrue(isValid, "새로 생성된 토큰 유효한지 확인");
    }

    @Test
    void validateToken_Expire() {


        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMCIsImlhdCI6MTc1MDc0NzQ5NCwiZXhwIjoxNzUwNzQ3Nzk0fQ.HJjWU-16RCxoF64illPgpbE0JZQr9aTQ-hsOINCkdqw";

        boolean isValid = jwtProcessor.validateToken(token);

        log.info("검증결과(true/false) : {}", isValid);

        assertFalse(isValid, "만료된 토큰은 무효해야함");
    }

    @Test
    void validateToken_Invalid() {

        // 이상한 토큰 (잘못된 형식)
        String token = "eyJhbGciOhwIjoxNzUwNzQ3Nzk0fQ.HJjWU-16RCxoF64illPgpbE0JZQr9aTQ-hsOINCkdqw";


        boolean isValid = jwtProcessor.validateToken(token);

        log.info("검증결과(true/false) : {}", isValid);

        assertFalse(isValid, "잘못된 형식의 토큰은 무효해야함");
    }
}