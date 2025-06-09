package org.basic.ex01.app;

import org.basic.ex01.config.ProjectConfig3;
import org.basic.ex01.domain.Parrot2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig3.class);

        Parrot2 p = context.getBean(Parrot2.class);

        System.out.println(p.getName());
    }
}
