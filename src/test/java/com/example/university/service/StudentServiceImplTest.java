package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @Mock
    private StudentRepository mockedStudentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

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