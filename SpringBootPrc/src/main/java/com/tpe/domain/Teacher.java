package com.tpe.dto;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_teacher")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Data//DTO'lar icin kullanılır
//@Getter-@Setter @ToString equals-hashcode @RequiredArgsConstructor anatasyonu bulunmaktadır
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)//DB ayarlamalarını yapmamı sağlar
    @NotBlank(message = "Name can not be space")//null,"","   " hata mesajını
    @Size(min = 2,max = 50)
    private String name;

    @Column(nullable = false)//DB ayarlamalarını yapmamı sağlar
    @NotBlank(message = "Lastname can not be space")//null,"","   " hata mesajını
    @Size(min = 2,max = 50)
    private String lastname;

    @Pattern(regexp = "[A-Z]",message = "The branch must be uppercase")
    private String branch;

    @Column(nullable = false,unique = true)//DB ayarlamalarını yapmamı sağlar
    @NotBlank(message = "phone can not be space")//null,"","   " hata mesajını
    @Size(min = 10,max = 14)
    //@Pattern(regexp = "\\d{10}")
    private String phone;

    @Email(message = "please provide valid email!!!")
    @Column(nullable = false,unique = true)
    //@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Email is not valid")
   /* `@Pattern` anotasyonu, belirli bir alanın belirli bir düzenli ifadeye (regex) uymasını sağlamak için kullanılır. Aşağıdaki örnekte, `email` alanının geçerli bir e-posta adresi formatında olup olmadığını kontrol eden bir regex kullanılmıştır:
            - `^` ifadesi, string'in başlangıcını belirtir.
            - `[a-zA-Z0-9+_.-]+` ifadesi, bir veya daha fazla harf (büyük veya küçük), rakam, artı işareti, alt çizgi, nokta veya tire karakterini eşleştirir.
            - `@` ifadesi, "@" karakterini eşleştirir.
            - `[a-zA-Z0-9.-]+` ifadesi, bir veya daha fazla harf (büyük veya küçük), rakam, nokta veya tire karakterini eşleştirir.
            - `$` ifadesi, string'in sonunu belirtir.
    Bu regex, `email` alanının geçerli bir e-posta adresi formatında olup olmadığını kontrol eder. Eğer `email` alanı bu regex ile eşleşmezse, belirtilen hata mesajı gösterilir.
     */
    private String email;



    private Long salary;
    @Setter(AccessLevel.NONE)//erisim olmasi
    private LocalDateTime dataTime = LocalDateTime.now();


}