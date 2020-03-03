package com.example.university.service;

import com.example.university.entity.Student;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(Long id) throws NotFoundException;

    List<Student> findAndSortedStudentByParams(Long age, String firstName, Boolean sortedFlag);

    Student addStudent(Student student);

    List<Student> getAllStudentsByGenderCode(Integer genderCode);
}
