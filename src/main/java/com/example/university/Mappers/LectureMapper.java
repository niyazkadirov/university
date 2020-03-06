package com.example.university.Mappers;

import com.example.university.dto.LectureDTO;
import com.example.university.entity.Lecture;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LectureMapper {


    public static LectureDTO mapLectureToDTO(Lecture lecture){
        return new LectureDTO(lecture.getStartTime(), lecture.getEndTime(),
                Duration.between(lecture.getStartTime(), lecture.getEndTime()),
                StudentMapper.mapStudentsToDTOList(lecture.getGroups().stream().
                        flatMap(group -> group.getStudents().stream()).collect(Collectors.toList()))
                );
    }

    public static List<LectureDTO> mapLectureToDTOList(List<Lecture> lectures){
        return lectures.stream().map(LectureMapper::mapLectureToDTO).collect(Collectors.toList());
    }
}
