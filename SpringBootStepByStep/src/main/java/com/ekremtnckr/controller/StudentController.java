package com.ekremtnckr.controller;

import com.ekremtnckr.domain.Student;
import com.ekremtnckr.dto.StudentDTO;
import com.ekremtnckr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
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
     //birden fazla filed istersek @RequestParam  kullaniriz

                Student student = studentService.findStudent(id);
                return ResponseEntity.ok(student);

// Bir data almak icin  @PathVariable kullanilir.
// Birden fazla data almak icin @RequestParam kullanilir.

            }
            //!!! Id ile ogrenci getirelim @PathVariable ile

         @GetMapping("{id}") //http://localhost:8080/students/1
         //herhangi bir endpoint beklemen sadece id gelsin diyorsak {} içine id yazılır.

      public ResponseEntity<Student>getStudentWithById(@PathVariable("id")Long id){
            //PathVariable ile gelen parametreyi alırız. //http://localhost:8080/students/1
            //birden fazla filed istersek @RequestParam  kullaniriz
             Student student =studentService.findStudent(id);
             return ResponseEntity.ok(student);
/*
Kullanicidan bir data alacaksam uc yol var
1-@RequestParam
2-@PathVariable
3-@RequestBody(JS
 */


         }

         //DELETE
            @DeleteMapping("/{id}") //http://localhost:8080/students/1
    public ResponseEntity<Map<String,String>>deleteStudent(@PathVariable("id")Long id){
        studentService.deleteStudent(id);
        Map<String,String>map = new HashMap<>();
        map.put("message","Student is deleted successfully");//Student basarili bir sekilde silindi
        map.put("status","true");//status true
        return new ResponseEntity<>(map,HttpStatus.OK);//200 kodunu HTTP Status Kodu olarak gonderir.

            }

        //UPDATE
    @PutMapping("/{id}") //http://localhost:8080/students/1 +PUT
    public ResponseEntity<Map<String,String>>updateStudent(@PathVariable("id")Long id,@Valid
                                                           @RequestBody StudentDTO studentDTO){

        studentService.updateStudent(id,studentDTO);
        Map<String,String>map = new HashMap<>();
        map.put("message","Student is updated successfully");//Student basarili bir sekilde silindi
        map.put("status","true");//status true
        return new ResponseEntity<>(map,HttpStatus.OK);//200 kodunu HTTP Status Kodu olarak gonderir.

    }

              //!!! Pageable
    //http://localhost:8080/students?page=0&size=2&sort=firstName,asc

@GetMapping("/students/page")
//http://localhost:8080/students/students/page?page=0&size=2&sort=firstName,asc
 public ResponseEntity<Page<Student>>getAllWithPage(
         @RequestParam("page")int page,//--> hangi page gonderlecek ..0 dan basliyor
         @RequestParam("size")int size,//--> page basi kac ogrenci gonderlecek
         @RequestParam("sort")String prop,//siralama hangi fielde gore yapilacak
         @RequestParam("direction") Sort.Direction direction){ //dogal sirali mi yoksa ters sirali mi olsun

    Pageable pageable = PageRequest.of(page,size,Sort.by(direction,prop));
    Page<Student>studentPage = studentService.getAllWithPage(pageable);
    return ResponseEntity.ok(studentPage);

  /*
  Controller da getAllWithPage metodu olusturuyoruz.Bu metot ile Pageable objesi olusturuyoruz.
  Bu methodun pageable mantiginda olmasi icin 4 tane paramete almali
     1-page--> hangi page'i istiyorum onu soylemeliyim
        2-size--> page basi kac ogrenci gosterilsin  onu soylemem gerek
        3-sort prop--> hangi field e gore siralama yapilacak
        4-direction--> siralama dogal mi yoksa ters mi olacak

   */
     }
 }
