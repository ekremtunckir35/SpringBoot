package com.tpe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //requestler bu classtaki metotlarlar eslestirilecek ve resposnlar hazirlanacak
//@ResponseBody :metodun dönüş değerini JSON formatında cevap olarak hazırlar
//restcontroller hem controller hemde responsebody anlamına gelir.
//restcontroller kullanıldığında metodlarin üzerine responsebody yazmaya gerek kalmaz.
//restcontroller ile controller arasındaki fark restcontrollerin üzerinde responsebody anotasyonu bulunur.
@RequestMapping("/students")//bu controllerin hangi urlde çalışacağını belirtir.
//http://localhost:8080/students  pathi ile bu controllera ulaşabiliriz.
public class StudentController {
}
