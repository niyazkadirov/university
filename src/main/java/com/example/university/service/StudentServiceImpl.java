package com.example.university.service;

import com.example.university.Mappers.studentService.studentTimetable.LectureMapper;
import com.example.university.Mappers.studentService.studentTimetable.StudentMapper;
import com.example.university.dto.studentService.studentTimetable.LectureDTO;
import com.example.university.dto.studentService.studentTimetable.StudentDTO;
import com.example.university.entity.Lecture;
import com.example.university.entity.Student;
import com.example.university.entity.enumeration.Day;
import com.example.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
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
    public void addStudent(Student student) {
        studentRepository.save(student);
    }


    @Override
    public StudentDTO getStudentTimetable(String firstName, String lastName) {

        Student student = studentRepository.findFirstByFirstNameAndLastName(firstName, lastName);

        Map<Day, List<Lecture>> lectureDTOMap =
                student.getGroup().getLectures().stream()
                        .collect(Collectors.groupingBy(Lecture::getDay));

        Map<Day, List<LectureDTO>> dayListMap = lectureDTOMap.keySet().stream()
                .collect(Collectors.toMap(day -> day, day ->
                        LectureMapper.mapLectureToDTOList(student.getGroup().getLectures()), (a, b) -> b, TreeMap::new));

        return StudentMapper.mapStudentToDTO(student, dayListMap);
    }

}
