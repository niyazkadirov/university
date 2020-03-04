package com.example.university.service;

import com.example.university.dto.teacherService.LectureDTO;
import com.example.university.dto.teacherService.StudentDTO;
import com.example.university.dto.teacherService.SubjectDTO;
import com.example.university.dto.teacherService.TeacherDTO;
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
        TeacherDTO teacherDTO = modelMapper.map(teacher, TeacherDTO.class);

        for (Lecture lecture : teacher.getLectures()) {
            List<StudentDTO> studentDTOList = new ArrayList<>();

            LectureDTO lectureDTO = modelMapper.map(lecture, LectureDTO.class);
            SubjectDTO subjectDTO = modelMapper.map(lecture.getSubject(), SubjectDTO.class);
            lectureDTO.setSubjectDTO(subjectDTO);

            for (Group group : lecture.getGroups()) {
                for (Student student : group.getStudents()) {
                    StudentDTO map = modelMapper.map(student, StudentDTO.class);
                    studentDTOList.add(map);
                }
            }

            lectureDTO.setStudentDTOList(studentDTOList);
            lectureDTOList.add(lectureDTO);
        }

        Map<Day, List<LectureDTO>> lectureDTOMap = lectureDTOList.stream()
                .collect(Collectors.groupingBy(LectureDTO::getDay));


        teacherDTO.setLectureDTOMap(lectureDTOMap);
        return teacherDTO;
    }

}
