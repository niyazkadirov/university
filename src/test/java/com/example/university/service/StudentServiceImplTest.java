package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @Mock
    private StudentRepository mockedStudentRepository;

    @Mock
    private List<Student> students;

    @InjectMocks
    private StudentServiceImpl studentService;


    @BeforeEach
    public void setUp(){
        when(mockedStudentRepository
                .findByFirstNameContainingAndBirthDateBefore(Mockito.anyString(),
                        Mockito.any(LocalDate.class))).thenReturn(students);
    }


    @Test
    public void findAndSortedStudentByParams_mustReturnStudentsWhoseNameContainsAndAgeMoreSortedAsc(){

    }


}