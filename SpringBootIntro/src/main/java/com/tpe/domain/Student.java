package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
@Getter //lombok kütüphanesinden gelen bir anotasyon. getter metodlarını otomatik olarak oluşturur.
        //tum fieldlar icin getter metodlari olusturur.
@Setter//lombok kütüphanesinden gelen bir anotasyon. setter metodlarını otomatik olarak oluşturur.
        //tum fieldlar icin setter metodlari olusturur.
@AllArgsConstructor//lombok kütüphanesinden gelen bir anotasyon. tüm alanları kullanarak bir constructor oluşturur.
            //tum fieldlar icin constructor olusturur.
@NoArgsConstructor//
//@RequiredArgsConstructor//lombok kütüphanesinden gelen bir anotasyon. final ve @NonNull olan alanlar için bir constructor oluşturur.
        //final ve @NonNull olan fieldlar icin constructor olusturur.


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)//sadece getter metodunu olusturur.
    private Long id;

    @NotBlank(message = "name can not be blank!")
    @Column(nullable = false)
    @Size(min = 2,max = 50,message = "name must be between 2 and 50 characters!")
    private String name;

    @NotBlank(message = "lastname can not be blank!")
    @Column(nullable = false)
    private String lastname;

    @NotNull(message = "please provide grade!")
    @Column(nullable = false)
    private Integer grade;

    //email formati olmasini saglamak icin @Email anotasyonu kullanilabilir.
    @Email(message = "please provide a valid email!")
    //@Pattern()
    @Column(nullable = false,unique = true)
    private String email;

    @Setter(AccessLevel.NONE)//sadece getter metodunu olusturur.Setter kaldirildi.
    private LocalDateTime createDate=LocalDateTime.now();

       //getter ve setterlar otomatik olusturduk Annatationslar ile



    }
