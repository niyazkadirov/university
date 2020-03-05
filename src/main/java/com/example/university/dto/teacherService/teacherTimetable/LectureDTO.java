package com.example.university.dto.teacherService.teacherTimetable;


import com.example.university.entity.enumeration.Day;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class LectureDTO {
    private Long audienceNumber;

    private LocalTime startTime;

    private LocalTime endTime;

    @JsonIgnore
    private Day day;

    private SubjectDTO subjectDTO;

    private List<StudentDTO> studentDTOList;

}
