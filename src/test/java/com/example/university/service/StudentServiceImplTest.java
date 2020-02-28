package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;
    

    @Test
    void addedStudentMustBeNotNull() {
        Student student = new Student();
        student.setFirstName("Bob");

        when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);
        Student savedStudent = studentService.addStudent(student);

        Assert.assertNotNull(savedStudent.getFirstName());
        Assert.assertEquals(savedStudent.getFirstName(), "Bob");

        Mockito.verify(studentRepository, Mockito.times(1)).save(student);
    }


}