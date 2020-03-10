package com.example.university.dto.studentService.studentTimetable;

import com.example.university.entity.enumeration.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureDTO {


    private Long audienceNumber;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration duration;

    private Day day;
    private TeacherDTO teacher;

    @JsonIgnore
    private SubjectDTO subject;
}
