package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void addedStudentMustNotBeNull() {
        Student student = new Student();
        student.setFirstName("Bob");
        when(studentRepository.save(Mockito.any(Student.class))).then(returnsFirstArg());
        Student savedStudent = studentService.addStudent(student);
        Assert.assertNotNull(savedStudent.getFirstName());
    }
}