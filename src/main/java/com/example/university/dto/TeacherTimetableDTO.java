package com.example.university.dto;

import com.example.university.entity.Lecture;
import com.example.university.entity.enumeration.Day;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class TeacherTimetableDTO {
    private String firstName;
    private String lastName;
    private Map<Day, List<LectureDTO>> dailyLectures;
}
