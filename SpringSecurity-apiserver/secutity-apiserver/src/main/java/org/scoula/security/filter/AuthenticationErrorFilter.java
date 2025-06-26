package org.scoula.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.scoula.security.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// JWT 인증 처리를 할때 발생할 수 있는 예외들을 처리하는 필터
@Component
public class AuthenticationErrorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        try {
            // 다음 필터 실행
            super.doFilter(request, response, filterChain);


            //JWT 만료되었을때
            // -> accessToken의 유효기간이 지나 더이상 사용 할 수 없을 떄
        } catch (ExpiredJwtException e) {
            // 토큰 만료 시 401 응답
            JsonResponse.sendError(
                    response,
                    HttpStatus.UNAUTHORIZED,
                    "토큰의 유효시간이 지났습니다."
            );
            // Unsupported wtException : 잘못된 형식의 JWT 일때
            // MalformedJwtException : 구조적으로 문제가 있는 JWT (필드 누락 on 인코딩 오류 등)
            // SianatuneExceotion : JWT 서명이 위조되었거나 검증 실패했을때

        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            // 기타 토큰 오류 시 401 응답
            JsonResponse.sendError(
                    response,
                    HttpStatus.UNAUTHORIZED,
                    e.getMessage()
            );

        } catch (ServletException e) {
            // 서버 오류 시 500 응답
            // 필터 처리 중 내부 오류가 생겼을 때 (기타 서버 예외)
            JsonResponse.sendError(
                    response,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
        }
    }
}
