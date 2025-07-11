package org.scoula.config;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //context파일로 인식됨.
public class ProjectConfig4 {

    //java context 파일로 주입하는 방법 2가지
    // 2, set()메서드 이용 : 먼저 Person 만들어지고 나서 parrot을 만들어 나중에 집어 넣는 방식
    // 나중에  주입하는 방식은 선호하지 ㅇㄴㅎ음
    //2. 생성자()메서드 이용 : 먼저 parrot을 만들어두고 Person을 만들 때 미리 만들어놓은
    // parrot 객체를 주임하여 Person을 만든다. 현재 제일 많이 사용함. 권장함
    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("koko");
        return p;
    }

    @Bean
    public Person person(Parrot parrot){
        Person p = new Person(); //객체생성후, 주입하는 경우 set메서드 이용해서 주입 가능
        //Person p = new Person(parrot);
        p.setName("Ella");
        // p.setParrot(parrot()); //주입할 때 set메서드 호출할 수 있음
        p.setParrot(parrot);
        //Person 만들기 전에 이미 만들어진 parrot 싱긅톤 객체를 찾아서 Person객체 만들때 주입
        return p;
    }

}
