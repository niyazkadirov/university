package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findStudent(Long age, String firstName, Boolean sortedFlag) {


        //need refactor
        if (age != null & firstName != null) {
            return studentRepository.findByFirstNameContainingAndBirthDateBefore(firstName, LocalDate.now().minusYears(age));
        } else if (age != null) {
            return studentRepository.findByBirthDateBefore(LocalDate.now().minusYears(age));
        } else if (firstName != null) {
            if (!sortedFlag) {
                return studentRepository.findByFirstNameContainingOrderByFirstNameDesc(firstName);
            } else {
                return studentRepository.findByFirstNameContainingOrderByFirstNameAsc(firstName);
            }
        } else {
            return studentRepository.findAll();
        }
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

}
