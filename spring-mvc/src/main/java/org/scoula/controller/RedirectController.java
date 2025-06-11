package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
public class RedirectController {

    @GetMapping("/result")
    public  String resultPage(){
        return "page/mappingResult";
    }

    /*
    * RedirectAttributes
    * - 리다이렉트시 데이터를 임시로 전달 할 수 있는 객체
    * - addFlashAttribute
    * */
    @GetMapping("/register")
    public  String resultUser(RedirectAttributes rttr){

        log.info("회원가입 진행중 .. ");

        rttr.addFlashAttribute("message", "회원가입 성공");

        // 클라이언트에게 "/result" 로 리다이렉트 지시
        return "redirect:/result";
    }
}
