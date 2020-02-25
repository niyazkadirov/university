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
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public ResponseEntity<List<Activity>> getAllActivity(){
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
    public ResponseEntity<List<Activity>> getAllByStartTimeBetween(String startTime, String endTime){

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime parseStartTime = dateTimeFormat.parse(startTime, LocalDateTime::from);
        LocalDateTime parseEndTime = dateTimeFormat.parse(endTime, LocalDateTime::from);

        List<Activity> activities = activityRepository.findAllByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(parseStartTime, parseEndTime);
        return new ResponseEntity<>(activities, HttpStatus.OK);

    }

}
