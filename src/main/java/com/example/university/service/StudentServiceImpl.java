package com.example.university.service;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Student> getStudentById(Long id) throws NotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("student for id" + id + "does not exist"));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> findStudent(Long age, String firstName, Boolean sortedFlag) {

        if (age != null & firstName != null) {
            List<Student> students = studentRepository.findByFirstNameContainingAndBirthDateBefore(firstName, LocalDate.now().minusYears(age));
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else if (age != null) {
            List<Student> students = studentRepository.findByBirthDateBefore(LocalDate.now().minusYears(age));
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else if (firstName != null) {
            if (!sortedFlag) {
                List<Student> students = studentRepository.findByFirstNameContainingOrderByFirstNameDesc(firstName);
                return new ResponseEntity<>(students, HttpStatus.OK);
            } else {
                List<Student> students = studentRepository.findByFirstNameContainingOrderByFirstNameAsc(firstName);
                return new ResponseEntity<>(students, HttpStatus.OK);
            }
        } else {
            List<Student> students = studentRepository.findAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

}
