package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {//ManyToOne
    //book tablosunda foreing key olusur.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @JsonProperty("bookName")
    //sadece JSON formatinda bu filedin isiminin belirtlenen isimde olmasini saglar,gosterilmesini saglar.
    private String name;

    @ManyToOne
    @JsonIgnore //bu fileldi JSON formatinda ignore et(gormezden gel)
    private Student student;
    //kitabi kayederken bu kitap hangi ogrenciye ait
    //bu ogrenciyi bulup set etmeliyiz



}
