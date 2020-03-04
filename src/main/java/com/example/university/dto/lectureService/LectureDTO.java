package com.example.university.dto.lectureService;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class LectureDTO {
    String title;
    LocalTime startTime;
    LocalTime endTime;
    Duration duration;
    List<StudentDTO> studentDTO;
}
