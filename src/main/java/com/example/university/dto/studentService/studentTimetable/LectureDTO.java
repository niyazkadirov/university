package com.example.university.dto.studentService.studentTimetable;

import com.example.university.entity.enumeration.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class LectureDTO {


    private Long audienceNumber;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;

    @JsonIgnore
    private Day day;
    private TeacherDTO teacher;
    private SubjectDTO subject;
}
