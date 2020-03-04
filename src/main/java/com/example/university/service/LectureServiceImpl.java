package com.example.university.service;

import com.example.university.dto.lectureService.LectureDTO;
import com.example.university.dto.lectureService.StudentDTO;
import com.example.university.entity.Lecture;
import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.Duration.between;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<Lecture> getAllActivity() {
        return lectureRepository.findAll();
    }

    @Override
    public List<Lecture> getAllByStartTimeBetween(LocalTime endTime, LocalTime startTime) {
        List<Lecture> lectures = lectureRepository.findAll();

        return lectures
                .stream()
                .filter(activity -> activity.getStartTime().isBefore(endTime) & activity.getEndTime().isAfter(startTime))
                .collect(Collectors.toList());
    }

    @Override
    public void addActivity(Lecture lecture) {
        lectureRepository.save(lecture);
    }


    @Override
    public List<LectureDTO> getJournal() {
        List<Lecture> lectures = lectureRepository.findAll();
        List<LectureDTO> lectureDTOList = new ArrayList<>();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        lectures.forEach(lecture -> {
            LectureDTO lectureDTO = modelMapper.map(lecture, LectureDTO.class);
            lectureDTO.setStudentDTO(studentDTOList);
            lectureDTO.setDuration(between(lecture.getEndTime(), lecture.getStartTime()));

            lecture.getGroups().stream()
                    .map(Group::getStudents)
                    .flatMap(Collection::stream)
                    .sorted(Comparator.comparing(Student::getFirstName))
                    .map(student -> modelMapper.map(student, StudentDTO.class))
                    .forEachOrdered(studentDTOList::add);

            lectureDTOList.add(lectureDTO);
        });

        return lectureDTOList;
    }
}