package org.lecture.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ClassA classA = context.getBean(ClassA.class);

        System.out.println("어플리케이션 장 작동중 ~₩₩");

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        if(str.equals("1")){

            classA.doSomething();
        }
        sc.close();
    }
}
