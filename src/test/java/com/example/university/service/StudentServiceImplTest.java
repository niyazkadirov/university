package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

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