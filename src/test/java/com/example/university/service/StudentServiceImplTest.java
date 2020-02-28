package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class StudentServiceImplTest {

    private StudentRepository mockedStudentRepository = mock(StudentRepository.class);


    private StudentServiceImpl studentService;


    @BeforeEach
    public void setUp() {
        studentService = new StudentServiceImpl(mockedStudentRepository);
    }

    @Test
    void addedStudentMustBeNotNull() {
        Student student = new Student();
        student.setFirstName("Bob");
        when(mockedStudentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        Student savedStudent = studentService.addStudent(student);

        Assert.assertNotNull(savedStudent.getFirstName());
        Assert.assertEquals(savedStudent.getFirstName(), "Bob");

        Mockito.verify(mockedStudentRepository, Mockito.times(1)).save(student);
    }


}