package com.example.university.Mappers;

import com.example.university.dto.studentService.studentTimetable.SubjectDTO;
import com.example.university.dto.teacherService.teacherTimeTable.LectureDTO;
import com.example.university.entity.Lecture;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LectureMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static LectureDTO mapLectureToDTO(Lecture lecture) {
        return new LectureDTO(modelMapper.map(lecture.getSubject(), SubjectDTO.class), lecture.getStartTime(), lecture.getEndTime(),
                lecture.getAudienceNumber(),
                StudentMapper.mapStudentsToDTOList(lecture.getGroups().stream().
                        flatMap(group -> group.getStudents().stream()).collect(Collectors.toList())),
                lecture.getDay()
        );
    }

    public static List<LectureDTO> mapLectureToDTOList(List<Lecture> lectures) {
        return lectures.stream().map(LectureMapper::mapLectureToDTO).collect(Collectors.toList());
    }
}
