package com.example.university.controller;

import com.example.university.model.Activity;
import com.example.university.model.Student;
import com.example.university.service.ActivityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;
import static org.springframework.format.annotation.DateTimeFormat.ISO.NONE;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/")
    public ResponseEntity<List<Activity>> getAllActivity() {
        return activityService.getAllActivity();
    }

    @GetMapping
    public ResponseEntity<Set<Student>> getAllStudentsActivityById(@RequestParam() Long id) throws NotFoundException {
        return activityService.getAllStudentsActivityById(id);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Activity>> getAllByStartTimeBetween(@RequestParam("startTime")
                                                                       //@DateTimeFormat(iso = DATE_TIME)
                                                                               LocalDateTime startTime,
                                                                   @RequestParam("endTime")
//                                                                        @DateTimeFormat(iso = DATE_TIME)
                                                                           LocalDateTime endTime) {
       // return activityService.getAllByStartTimeBetween(endTime, startTime);
        return null;
    }
}
