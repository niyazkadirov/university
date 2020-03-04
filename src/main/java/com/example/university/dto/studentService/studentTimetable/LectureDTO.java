package com.example.university.dto.studentService.studentTimetable;

import com.example.university.entity.enumeration.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class LectureDTO {


    private Long audienceNumber;

    private LocalTime startTime;

    private LocalTime endTime;

    @JsonIgnore
    private Day day;

    private TeacherDTO teacher;

    private SubjectDTO subject;
}
