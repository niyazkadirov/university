package com.example.university.service;

import com.example.university.model.Activity;
import com.example.university.model.Student;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface ActivityService {

    ResponseEntity<List<Activity>> getAllActivity();

    ResponseEntity<Set<Student>> getAllStudentsActivityById(Long id) throws NotFoundException;

    ResponseEntity<List<Activity>> getAllByStartTimeBetween(LocalTime startTime, LocalTime endTime);

    void addActivity(Activity activity);
}
