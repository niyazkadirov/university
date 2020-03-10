package com.example.university.Mappers.studentService.studentTimetable;

import com.example.university.dto.studentService.studentTimetable.LectureDTO;
import com.example.university.dto.studentService.studentTimetable.StudentDTO;
import com.example.university.entity.Student;

import java.util.List;
import java.util.Map;

public class StudentMapper {

    public static StudentDTO mapStudentToDTO(Student student, Map<String, List<LectureDTO>> lectureDTOMap) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getGroup().getTitle(), lectureDTOMap);
    }
}
