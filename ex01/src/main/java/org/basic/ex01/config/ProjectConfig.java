package org.basic.ex01.config;

import org.basic.ex01.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot(){
        Parrot p = new Parrot();
        p.setName("koko");
        return p;
    }
}
