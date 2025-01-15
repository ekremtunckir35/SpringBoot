package com.ekremtnckr.domain;



import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Getter
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "first name can not be null")
    @NotBlank(message="fist name can not be white space")
    @Size(min=2,max=25,message =
            "First name '${validatedValue}' must be between {min} and {max} long")
    @Column(nullable = false, length = 25)
    //@Getter
    /*final*/ private String name; // A

    @Column(nullable = false,length = 25)
    /*final*/ private String lastName;

    /*final*/ private  Integer grade;


    @Column(nullable = false,length = 50, unique = true)
    @Email(message="Provide valid email")
    /*final*/ private String email; //xxx@yyy.com

    /*final*/ private String phoneNumber;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();





    //Getter and Setter methods


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public Integer getGrade() {
//        return grade;
//    }
//
//    public void setGrade(Integer grade) {
//        this.grade = grade;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }
    //Constructor methods

//    public Student(String name, String lastname, Integer grade, String email, String phoneNumber) {
//        this.name = name;
//        this.lastname = lastname;
//        this.grade = grade;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }

//    public Student() {
//    }
}
