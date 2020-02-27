package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.entity.enumeration.Gender;
import com.example.university.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void initStudentServiceImpl(){
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void addStudent() {
        Student student = new Student("Niyaz", "Kadirov", Gender.MALE, LocalDate.now());
        Mockito.when(studentRepository.save(Mockito.any(Student.class)));
    }
}