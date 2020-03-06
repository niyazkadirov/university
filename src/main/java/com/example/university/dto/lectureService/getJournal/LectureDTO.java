package com.example.university.dto.lectureService.getJournal;

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
    String title;
    LocalTime startTime;
    LocalTime endTime;
    Duration duration;
    List<StudentDTO> studentDTO;
}
