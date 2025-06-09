package org.basic.ex01.app;

import org.basic.ex01.config.ProjectConfig2;
import org.basic.ex01.domain.Parrot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());
    }
}
