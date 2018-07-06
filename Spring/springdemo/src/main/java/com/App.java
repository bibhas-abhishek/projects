package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        BackendDeveloper developer = applicationContext.getBean("backendDeveloper", BackendDeveloper.class);
        System.out.println(developer.getName());
        System.out.println(developer.getDesignation() + " " + developer.getDeveloperType());
        System.out.print(developer.getAge());
    }

}
