package org.basic.ex02.Main;

import org.basic.ex02.beans.Person2;
import org.basic.ex02.config.ProjectConfig2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        Person2 p = context.getBean(Person2.class);

        System.out.println(p.getName());
        System.out.println(p.getParrot());
    }
}
