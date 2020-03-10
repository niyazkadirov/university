package com.example.university.service;

import com.example.university.dto.studentService.studentTimetable.StudentDTO;
import com.example.university.entity.Student;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(Long id) throws NotFoundException;

    List<Student> findAndSortedStudentByParams(Long age, String firstName, Boolean sortedFlag);

    void addStudent(Student student);

    List<Student> getAllStudentsByGenderCode(Integer genderCode);

    StudentDTO getStudentTimetable(String firstName, String lastName);
}