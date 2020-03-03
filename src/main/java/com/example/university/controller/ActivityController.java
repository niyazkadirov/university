package com.example.university.controller;

import com.example.university.dto.ActivityDTO;
import com.example.university.entity.Activity;
import com.example.university.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/")
    public ResponseEntity<List<Activity>> getAllActivity() {
        List<Activity> activities = activityService.getAllActivity();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }


    @GetMapping("/date")
    public ResponseEntity<List<Activity>> getAllByStartTimeBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {
        List<Activity> activities = activityService.getAllByStartTimeBetween(endTime, startTime);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PostMapping
    public void addActivity(Activity activity) {
        activityService.addActivity(activity);
    }

    @GetMapping(value = "/journal")
    public ResponseEntity<List<ActivityDTO>> getJournal() {
        List<ActivityDTO> journal = activityService.getJournal();
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }
}
