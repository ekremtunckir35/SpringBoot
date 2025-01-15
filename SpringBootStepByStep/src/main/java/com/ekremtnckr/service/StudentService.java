package com.ekremtnckr.service;

import com.ekremtnckr.domain.Student;
import com.ekremtnckr.dto.StudentDTO;
import com.ekremtnckr.exception.ConflictException;
import com.ekremtnckr.exception.ResourceNotFoundException;
import com.ekremtnckr.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public void deleteStudent(Long id) {
          Student student=findStudent(id);
          studentRepository.delete(student);
    }

    public void updateStudent(Long id,  StudentDTO studentDTO) {
              boolean existEmail =studentRepository.existsByEmail(studentDTO.getEmail());

        Student student =findStudent(id);


        if(existEmail && !studentDTO.getEmail().equals(student.getEmail())){
            throw new ConflictException(("Email is already exist"));
            /*
            kendi emailim :ekrem@gml.com update formunda da  ekrem diye kaldi.
            o zaman if ilk kismi existEmail true gelir ve
            studentDTO.getEmail().equals(student.getEmail()) false gelir.
            ve bu durumda hata firlatir.
            true  && False  ---> true olur update olur.

            2. durumda ise kendi email ekrem ,ahmet diye gunclleyecegim normalde db de ahmet var
            bu durumda exception firlatmasi gerekir.
            ilk kisim true gelir ve studentDTO.getEmail().equals(student.getEmail()) true gelir.
            ikinci kisim true && true ---> true olur ve hata firlatir.UPDATE OLMAZ

            3.senarto  ise kendi email ekrem ,mehmet  diye gunclleyecegim db de yok.
            bu durumda exception firlatmasi gerekir.
            dto dan mehmet geldi,db da mehmet yok o zaman false olur.--UPDATE OLUR


           */


        }
        //gelen dto pojo ya cevirmem gerekiyor

        student.setName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setGrade(studentDTO.getGrade());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        studentRepository.save(student);
    }

    public Page<Student> getAllWithPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}