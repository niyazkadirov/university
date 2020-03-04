package com.example.university.service;

import com.example.university.entity.Student;
import com.example.university.entity.enumeration.Gender;
import com.example.university.repository.StudentRepository;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository mockedStudentRepository;

    private List<Student> testStudents = new ArrayList<>();

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        when(mockedStudentRepository
                .findAll()).thenReturn(testStudents);

        testStudents.add(new Student(null, "Agata", null, Gender.FEMALE, null, null));
        testStudents.add(new Student(null, "Magdalena", null, Gender.FEMALE, null, null));
        testStudents.add(new Student(null, "Dorotea", null, Gender.UNDEFINED, null, null));
        testStudents.add(new Student(null, "Andrea", null, Gender.MALE, null, null));
        testStudents.add(new Student(null, "Mike", null, Gender.MALE, null, null));
        testStudents.add(new Student(null, "Cris", null, Gender.MALE, null, null));
        testStudents.add(new Student(null, "Marta", null, Gender.FEMALE, null, null));
    }

    @Test
    void InitArrayList_ShouldPass() {
        List<Student> students = mockedStudentRepository.findAll();
        Assert.assertEquals(students.size(), 7);
    }


    @Test
    void getAllStudentsByGenderCode_ValidCode_ShouldPass() {
        List<Student> students = studentService.getAllStudentsByGenderCode(1);

        for (Student student : students) {
            Assert.assertEquals(Gender.FEMALE.getCode(), student.getGender().getCode());
        }

        Mockito.verify(mockedStudentRepository, Mockito.times(1)).findAll();
    }


    @Test
    void GetAllStudentsByGenderCode_NegativeCode_ShouldReturnEmptyListStudents() {
        List<Student> students = studentService.getAllStudentsByGenderCode(-3);
        Assert.assertEquals(students.size(), 0);
        Mockito.verify(mockedStudentRepository, Mockito.times(1)).findAll();
    }

    @Test
    void GetAllStudentsByGenderCode_NullCode_ShouldReturnAllStudents() {
        List<Student> students = studentService.getAllStudentsByGenderCode(null);
        Assert.assertEquals(students.size(), 7);
        Mockito.verify(mockedStudentRepository, Mockito.times(1)).findAll();
    }
}