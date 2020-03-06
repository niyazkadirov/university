package com.example.university.service;

import com.example.university.dto.teacherService.teacherTimetable.LectureDTO;
import com.example.university.dto.teacherService.teacherTimetable.StudentDTO;
import com.example.university.dto.teacherService.teacherTimetable.SubjectDTO;
import com.example.university.dto.teacherService.teacherTimetable.TeacherDTO;
import com.example.university.entity.Group;
import com.example.university.entity.Lecture;
import com.example.university.entity.Student;
import com.example.university.entity.Teacher;
import com.example.university.entity.enumeration.Day;
import com.example.university.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public TeacherDTO getTeacherTimetable(Long teacherId) {

        List<LectureDTO> lectureDTOList = new ArrayList<>();
        Teacher teacher = teacherRepository.findById(teacherId).get();

        for (Lecture lecture : teacher.getLectures()) {
            List<StudentDTO> studentDTOList = new ArrayList<>();

            LectureDTO lectureDTO = modelMapper.map(lecture, LectureDTO.class);
            lectureDTO.setSubjectDTO(modelMapper.map(lecture.getSubject(), SubjectDTO.class));

            for (Group group : lecture.getGroups()) {
                for (Student student : group.getStudents()) {
                    studentDTOList.add(modelMapper.map(student, StudentDTO.class));
                }
            }

            lectureDTO.setStudentDTOList(studentDTOList);
            lectureDTOList.add(lectureDTO);
        }

        Map<Day, List<LectureDTO>> lectureDTOMap;
        lectureDTOMap = lectureDTOList.stream()
                .collect(Collectors.groupingBy(LectureDTO::getDay))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        TeacherDTO teacherDTO = modelMapper.map(teacher, TeacherDTO.class);
        teacherDTO.setLectureDTOMap(lectureDTOMap);

        return teacherDTO;
    }
}