package com.example.university.service;

import com.example.university.entity.Student;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<Student> getStudentById(Long id) throws NotFoundException;

    ResponseEntity<List<Student>> findStudent(Long age, String firstName, Boolean sortedFlag);

    void addStudent(Student student);

}
