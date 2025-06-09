package org.basic.ex02.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot2 {
    private String name;

    @PostConstruct
    public void init(){
        this.name = "Koko";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
