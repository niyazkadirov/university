package com.example.university.dto.teacherService;

import com.example.university.entity.enumeration.Day;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TeacherDTO {
    private String firstName;

    private String lastName;

    private Map<Day, List<LectureDTO>> lectureDTOMap;
}
