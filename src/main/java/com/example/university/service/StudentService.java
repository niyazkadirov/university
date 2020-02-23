package com.example.university.service;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<Student> getStudentById(Long id) throws ResourceNotFoundException;

    ResponseEntity<List<Student>> findStudent(Long age, String firstName, Boolean flag);

    void addStudent(Student student);

}
