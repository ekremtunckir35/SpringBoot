package com.ekremtnckr.controller;

import com.ekremtnckr.domain.Student;
import com.ekremtnckr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")//htttp://localhost:8080/students
public class StudentController {

    @Autowired
    private StudentService studentService;

    //!!! Get All Students(Butun ogrencileri getirelim)
    @GetMapping //http://localhost:8080/students + GET
    public ResponseEntity<List<Student>> getAll(){ //

        List<Student>students =studentService.getAll();

        return  ResponseEntity.ok(students);//200 kodunu HRRP Status Kodu olrak gonderir.

    }

    //!!! Student objesi olusturalim

         @PostMapping //http://localhost:8080/students + POST +JSON


        public ResponseEntity<Map<String,String>>createStudent(@Valid  @RequestBody Student student){
             // @Valid : parametreler valid mi kontrol eder, bu örenekte Student
             //objesi oluşturmak için  gönderilen fieldlar yani
             //name gibi özellikler düzgün set edilmiş mi ona bakar.

             // @RequestBody = gelen parametreyi, requestin bodysindeki bilgilerin,
             //Student objesine map edilmesini sağlıyor.

            studentService.createStudent(student);

            Map<String,String>map = new HashMap<>();

            map.put("message","Student is created successfully");//Student basarili bir sekilde olusturuldu
            map.put("status","true");//status true

            return new  ResponseEntity<>(map, HttpStatus.CREATED);//201 kodunu HTTP Status Kodu olarak gonderir.

         }

         //Id ile ogrenci getirelim-->@RequestParam ile
            @GetMapping("query") //http://localhost:8080/students/query?id =1
     public ResponseEntity<Student>getStudent(@RequestParam("id")Long id){
        //burada tek bir data var ise  yani id=1 ise "id"  parametresini yazmaya gerek yoktur.
        //birden fazla parametre var ise @RequestParam("id")Long id, @RequestParam("name")String name gibi yazılır.
     //RequestParam ile gelen parametreyi alırız. //http://localhost:8080/students/query?id=1

                Student student = studentService.findStudent(id);
                return ResponseEntity.ok(student);



            }

}
