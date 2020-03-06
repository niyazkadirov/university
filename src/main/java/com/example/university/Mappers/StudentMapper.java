package com.example.university.Mappers;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentDTO mapStudentToDTO(Student student){
        return new StudentDTO(student.getFirstName(), student.getLastName());
    }

    public static List<StudentDTO> mapStudentsToDTOList(List<Student> students){
        return students.stream().map(StudentMapper::mapStudentToDTO).collect(Collectors.toList());
    }
}
