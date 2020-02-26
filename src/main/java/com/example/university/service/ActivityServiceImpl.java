package com.example.university.service;

import com.example.university.dto.LectureDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.entity.Activity;
import com.example.university.entity.Student;
import com.example.university.repository.ActivityRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<Activity>> getAllActivity() {
        List<Activity> activities = activityRepository.findAll();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<Student>> getAllStudentsActivityById(Long id) throws NotFoundException {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
        Set<Student> students = activity.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Activity>> getAllByStartTimeBetween(LocalTime endTime, LocalTime startTime) {
        List<Activity> activities = activityRepository.findAll();

        List<Activity> sortedActivities = activities
                .stream()
                .filter(activity -> activity.getStartTime().isBefore(endTime) & activity.getEndTime().isAfter(startTime))
                .collect(Collectors.toList());

        return new ResponseEntity<>(sortedActivities, HttpStatus.OK);
    }

    @Override
    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }


    @Override
    public ResponseEntity<List<LectureDTO>> getJournal() {
        List<Activity> activities = activityRepository.findAll();
        List<LectureDTO> lectureDTOList = new ArrayList<>();

        for (Activity activity : activities) {
            LectureDTO lectureDTO = modelMapper.map(activity, LectureDTO.class);
            lectureDTO.setDuration(Duration.between(activity.getEndTime(), activity.getStartTime()));

            List<StudentDTO> studentDTOList = new ArrayList<>();

            for (Student student : activity.getStudents()) {
                StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
                studentDTO.setTitle(student.getGroup().getTitle());
                studentDTOList.add(studentDTO);
            }

            lectureDTO.setStudentsDTO(studentDTOList);
            lectureDTOList.add(lectureDTO);
        }
        return new ResponseEntity<>(lectureDTOList, HttpStatus.OK);
    }
}
