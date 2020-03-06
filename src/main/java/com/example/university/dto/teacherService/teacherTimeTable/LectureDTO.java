package com.example.university.dto.teacherService.teacherTimeTable;

import com.example.university.dto.studentService.studentTimetable.SubjectDTO;
import com.example.university.entity.enumeration.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
public class LectureDTO {
    private SubjectDTO subject;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long audienceNumber;
    private List<StudentDTO> students;

    @JsonIgnore
    private Day day;


}
