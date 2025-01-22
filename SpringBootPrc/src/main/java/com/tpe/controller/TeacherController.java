package com.tpe.controller;

import com.tpe.dto.TeacherDTO;
import com.tpe.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController//request (isteklerin) json formatindaki degeri kjava objesine donusturmeyi saglar.
@RequestMapping("/teachers")
public class TeacherControlller {

    //reguest:http://localhost:8080/teachers/hello + GET
    //response:hello spring boot

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }
      private TeacherService teacherService
    //save teacher
    //request:http://localhost:8080/teachers/save + POST
    //response:db e kayit +message +201 created//http status code

    @PostMapping("/save")

    public ResponseEntity<String>createTeacher(@Valid @RequestBody TeacherDTO teacherDTO){//DTO
        teacherService.saveTeacher(teacherDTO);
        return ResponseEntity.ok("Teacher created");
    }
}