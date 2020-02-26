package com.example.university.controller;

import com.example.university.entity.Activity;
import com.example.university.entity.Student;
import com.example.university.service.ActivityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/")
    public ResponseEntity<List<Activity>> getAllActivity() {
        return activityService.getAllActivity();
    }

    @GetMapping("/student")
    public ResponseEntity<Set<Student>> getAllStudentsActivityById(@RequestParam() Long id) throws NotFoundException {
        return activityService.getAllStudentsActivityById(id);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Activity>> getAllByStartTimeBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {
        return activityService.getAllByStartTimeBetween(endTime, startTime);
    }

    @PostMapping
    public void addActivity(Activity activity) {
        activityService.addActivity(activity);
    }
}
