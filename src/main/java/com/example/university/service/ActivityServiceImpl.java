package com.example.university.service;

import com.example.university.model.Activity;
import com.example.university.model.Student;
import com.example.university.repository.ActivityRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

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
    public ResponseEntity<List<Activity>> getAllByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime) {
        List<Activity> activities = activityRepository.findAll();

        List<Activity> sortedActivities = activities
                .stream()
                .filter(activity -> activity.getStartTime().isBefore(startTime) & activity.getEndTime().isAfter(endTime))
                .collect(Collectors.toList());

        return new ResponseEntity<>(sortedActivities, HttpStatus.OK);

    }
}
