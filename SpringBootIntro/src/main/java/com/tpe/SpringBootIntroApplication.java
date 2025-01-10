package com.tpe;

import com.tpe.domain.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//componentscann bu classiin icinde bulundugu package default olarak tarar.
//bu classin icindeki package ve altindaki package leri tarar.
public class SpringBootIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);

//        Student student = new Student();
//        student.getEmail();
//        student.setName("Ali");

    }

}
