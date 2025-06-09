package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {

    private String name;
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    // Set읋 사용한 의존성 주입
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
