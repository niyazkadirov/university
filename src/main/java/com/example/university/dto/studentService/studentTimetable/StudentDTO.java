package com.example.university.dto.studentService.studentTimetable;

import com.example.university.entity.enumeration.Day;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String groupTitle;
    private Map<Day, List<LectureDTO>> lectureDTOMap;
}
