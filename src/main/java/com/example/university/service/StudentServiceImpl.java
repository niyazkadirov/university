package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAndSortedStudentByParams(Long age, String firstName, Boolean sortedFlag) {

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
    public List<Student> getAllStudentsByGenderCode(Integer genderCode) {
        if (genderCode == null) {
            return studentRepository.findAll();
        }

        List<Student> students = studentRepository.findAll();
        return students.stream()
                .filter(student -> student.getGender().getCode() == genderCode)
                .collect(Collectors.toList());
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

}
