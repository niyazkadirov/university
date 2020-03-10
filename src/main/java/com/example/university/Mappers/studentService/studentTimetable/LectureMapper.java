package com.example.university.Mappers.studentService.studentTimetable;

import com.example.university.dto.studentService.studentTimetable.LectureDTO;
import com.example.university.dto.studentService.studentTimetable.SubjectDTO;
import com.example.university.dto.studentService.studentTimetable.TeacherDTO;
import com.example.university.entity.Lecture;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LectureMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static LectureDTO mapLectureToDTO(Lecture lecture) {
//
        Duration lectureDuration = Duration.between(lecture.getStartTime(), lecture.getEndTime());
        TeacherDTO teacherDTO = modelMapper.map(lecture.getTeacher(), TeacherDTO.class);
        SubjectDTO subjectDTO = modelMapper.map(lecture.getSubject(), SubjectDTO.class);

        return new LectureDTO(lecture.getAudienceNumber(), lecture.getStartTime(), lecture.getEndTime(), lectureDuration, lecture.getDay(), teacherDTO, subjectDTO);
    }

    public static List<LectureDTO> mapLectureToDTOList(List<Lecture> lectures) {
        return lectures.stream().map(LectureMapper::mapLectureToDTO).collect(Collectors.toList());
    }
}