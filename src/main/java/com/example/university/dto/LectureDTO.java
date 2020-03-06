package com.example.university.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class LectureDTO {

    LocalTime startTime;
    LocalTime endTime;
    Duration duration;
    List<StudentDTO> studentDTO;
}
