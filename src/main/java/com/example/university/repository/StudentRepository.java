package com.example.university.repository;

import com.example.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByBirthDateBefore(LocalDate birthDate);
    List<Student> findByFirstNameContainingOrderByFirstNameAsc(String firstName);
    List<Student> findByFirstNameContainingOrderByFirstNameDesc(String firstName);
    List<Student> findByFirstNameContainingAndBirthDateBefore(String firstName, LocalDate birthDate);


}

