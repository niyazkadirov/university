package com.example.university.service;

import com.example.university.dto.studentService.studentTimetable.LectureDTO;
import com.example.university.dto.studentService.studentTimetable.StudentDTO;
import com.example.university.dto.studentService.studentTimetable.SubjectDTO;
import com.example.university.dto.studentService.studentTimetable.TeacherDTO;
import com.example.university.entity.Lecture;
import com.example.university.entity.Student;
import com.example.university.entity.enumeration.Day;
import com.example.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;


    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAndSortedStudentByParams(Long age, String firstName, Boolean sortedFlag) {

        //need refactor
        if (age != null & firstName != null) {
            return studentRepository.findByFirstNameContainingAndBirthDateBefore(firstName, LocalDate.now().minusYears(age));
        } else if (age != null) {
            return studentRepository.findByBirthDateBefore(LocalDate.now().minusYears(age));
        } else if (firstName != null) {
            if (!sortedFlag) {
                return studentRepository.findByFirstNameContainingOrderByFirstNameDesc(firstName);
            } else {
                return studentRepository.findByFirstNameContainingOrderByFirstNameAsc(firstName);
            }
        } else {
            return studentRepository.findAll();
        }
    }

    @Override
    public List<Student> getAllStudentsByGenderCode(Integer genderCode) {
        if (genderCode == null) {
            return studentRepository.findAll();
        }

        List<Student> students = studentRepository.findAll();
        return students.stream()
                .filter(student -> student.getGender().getCode() == genderCode)
                .collect(Collectors.toList());
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public StudentDTO getStudentTimetable(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        List<LectureDTO> lectureDTOList = new ArrayList<>();

        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

        for (Lecture lecture : student.getGroup().getLectures()) {

            LectureDTO lectureDTO = modelMapper.map(lecture, LectureDTO.class);
            TeacherDTO teacherDTO = modelMapper.map(lecture.getTeacher(), TeacherDTO.class);
            SubjectDTO subjectDTO = modelMapper.map(lecture.getSubject(), SubjectDTO.class);

            lectureDTO.setTeacher(teacherDTO);
            lectureDTO.setSubject(subjectDTO);
            lectureDTOList.add(lectureDTO);
        }
        Map<Day, List<LectureDTO>> lectureDTOMap =
                lectureDTOList.stream()
                        .collect(Collectors.groupingBy(LectureDTO::getDay))
                        .entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        studentDTO.setLectureDTOMap(lectureDTOMap);

        return studentDTO;
    }

}
