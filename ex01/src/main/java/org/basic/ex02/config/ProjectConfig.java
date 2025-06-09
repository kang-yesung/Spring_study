package org.basic.ex02.config;

import org.basic.ex02.beans.Parrot;
import org.basic.ex02.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot(){
        Parrot parrot =new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    public Person person(Parrot parrot){
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot);
        return person;
    }
}
