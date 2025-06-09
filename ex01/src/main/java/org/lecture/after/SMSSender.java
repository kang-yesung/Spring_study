package org.lecture.after;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 동일 타입의 여러 빈 중 우선 주입됨
public class SMSSender extends EmailSender {

    // 문자 보내는 기능이라고 가정
    @Override
    public void send(String message) {
        System.out.println("이메일 발송: " + message);
    }

}
