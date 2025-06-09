package org.basic.ex01.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot2 {
    private String name;

    @PostConstruct
    public void init(){
        this.name = "Kiki";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
