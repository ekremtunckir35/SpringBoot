package com.ekremtnckr.repository;

import com.ekremtnckr.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


        boolean existsByEmail(String email);
  // Spring Data JPA içinde existById() var fakat Spring Data JPA bize sondaki eki istediğimiz değişken ismi ile
  //değiştirmemize izin veriyor, mevcut metodu bu şekilde türetebiliyoruz.

    }
