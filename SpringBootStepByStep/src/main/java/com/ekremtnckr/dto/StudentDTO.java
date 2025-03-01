package com.ekremtnckr.dto;

import com.ekremtnckr.domain.Student;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {



    private Long id;

    @NotNull(message = "first name can not be null")
    @NotBlank(message="fist name can not be white space")
    @Size(min=2,max=25,message =
            "First name '${validatedValue}' must be between {min} and {max} long")


     private String firstName; // A

    private String lastName;

     private  Integer grade;


    @Email(message="Provide valid email")
    private String email; //xxx@yyy.com

    private String phoneNumber;


    private LocalDateTime createDate = LocalDateTime.now();

         public StudentDTO(Student student){
             this.id=student.getId();
                this.firstName=student.getName();
                this.lastName=student.getLastName();
                this.grade=student.getGrade();
                this.email=student.getEmail();
                this.phoneNumber=student.getPhoneNumber();
                this.createDate=student.getCreateDate();

         }

}

//DTO  da cont. neden kullanırız?
//Amacim Servis katmaninda student pojo classlarini DTO ya cevirmek eger database den geliyorsa ,
// client katmanina gidecekse,bu durumda constructor ile cagiririz.