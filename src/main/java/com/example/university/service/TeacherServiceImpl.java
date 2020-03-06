package com.example.university.service;

import com.example.university.Mappers.LectureMapper;
import com.example.university.dto.teacherService.teacherTimeTable.LectureDTO;
import com.example.university.dto.teacherService.teacherTimeTable.TeacherTimetableDTO;
import com.example.university.entity.Lecture;
import com.example.university.entity.Teacher;
import com.example.university.entity.enumeration.Day;
import com.example.university.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherTimetableDTO getTimetable(String firstName, String lastName) {
        Teacher teacher = teacherRepository.findFirstByFirstNameAndLastName(firstName, lastName);

        Map<Day, List<Lecture>> dailyLectures = teacher.getLectures().stream().collect(
                groupingBy(Lecture::getDay));

        Map<Day, List<LectureDTO>> dayListMap = new TreeMap<>();

        for (Day day : dailyLectures.keySet()) {
            dayListMap.put(day, LectureMapper.mapLectureToDTOList(dailyLectures.get(day)));
        }

        return new TeacherTimetableDTO(firstName, lastName, dayListMap);
    }
}
