package com.example.university.service;

import com.example.university.entity.Student;
import javassist.NotFoundException;

import java.util.List;

public interface StudentService {

    Student getStudentById(Long id) throws NotFoundException;

    List<Student> findStudent(Long age, String firstName, Boolean sortedFlag);

    void addStudent(Student student);

}
