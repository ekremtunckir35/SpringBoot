package com.ekremtnckr.service;

import com.ekremtnckr.domain.Student;
import com.ekremtnckr.exception.ConflictException;
import com.ekremtnckr.exception.ResourceNotFoundException;
import com.ekremtnckr.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void createStudent(@Valid Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new ConflictException(("This email is already exist"));

        }
        studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student not found with id: " + id));

        return studentRepository.findById(id).get();
    }
}