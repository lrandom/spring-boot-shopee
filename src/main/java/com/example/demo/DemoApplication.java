package com.example.demo;

import com.example.demo.jpamysql.UserJpa;
import com.example.demo.models.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigServletWebServerApplicationContext  context = (AnnotationConfigServletWebServerApplicationContext) SpringApplication.run(DemoApplication.class, args);
/*        Girl girl = context.getBean(Girl.class);
        System.out.println(girl.getName());


        UserJpa userJpa = context.getBean(UserJpa.class);
        User user = new User();
        user.setUsername("Luân");



        userJpa.save(user);*/

    }




}
