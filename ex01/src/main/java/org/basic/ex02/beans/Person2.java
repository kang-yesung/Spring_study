package org.basic.ex02.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Person2 {
    private String name;
    private Parrot2 parrot;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }

    @Autowired
    public void setParrot(Parrot2 parrot) {
        this.parrot = parrot;
    }

    @PostConstruct
    public void init(){
        this.name = "Ella";
    }
}
