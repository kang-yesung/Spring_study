package org.scoula.controller;


import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/security")
@Log4j2
public class SecurityController {

    @GetMapping("/all")
    public void doAll() {
        log.info("비회원, 회원 모두 접근 가능");
    }

    @GetMapping("/member")
    public void doMember() {
        log.info("회원과 관리자만 모두 접근 가능 페이지");

    }

    @GetMapping("/admin")
    public void doAdmin() {
        log.info("관리자 접근 가능 페이지");
    }

    @GetMapping("/login")
    public void doLogin() {
        log.info("로그인 페이지 전환");
    }

    @GetMapping("/logout")
    public void doLogout() {
        log.info("로그아웃 페이지 전환");
    }

    /*
     * ○ Principal 주입
     * ○ Authentication 주입
     * ○ @AuthenticationPrincipal 주입
     * */


    // 가장 단순한 방식 -> 로그인한 사용자의 username만 필요할 때 사용
    @GetMapping("/member/principal")
    public void printUserDetailByPrincipal(Principal principal) {
        log.info("username =====> {}", principal.getName());
    }

    //사용자 이름뿐 아니라 권한, 인증상태, 자격 증명 등 접근 가능
    @GetMapping("/member/authentication")
    public void printUserDetailByAuthentication(Authentication authentication) {
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        log.info("username =======> {}", userDetails.getUsername());
    }

    // SpringSecurity가 authentication.getPrincipal()에서 꺼낸 객체를 직접 주입
    // -> CustomUserDetails(구현체)에 접근 가능(CustomUser)
    @GetMapping("/member/authentication-principal")
    public void printUserDetailByAuthenticationPrincipal(
            @AuthenticationPrincipal CustomUser customUser) {

        MemberVO memberVO = customUser.getMember();
        log.info("memberVO ======> {}", memberVO);
    }
}
