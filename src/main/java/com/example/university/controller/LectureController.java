package com.example.university.controller;

import com.example.university.dto.lectureService.getJournal.LectureDTO;
import com.example.university.entity.Lecture;
import com.example.university.service.LectureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
@Api(tags = {"Lecture"})
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/")
    @ApiOperation(value = "Get all lectures", response = ResponseEntity.class)
    public ResponseEntity<List<Lecture>> getAllLectures() {
        List<Lecture> activities = lectureService.getAllActivity();
        return ResponseEntity.ok(activities);
    }


    @GetMapping("/date")
    @ApiOperation(value = "Get all lectures by start time between", response = ResponseEntity.class)
    public ResponseEntity<List<Lecture>> getAllByStartTimeBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {
        List<Lecture> activities = lectureService.getAllByStartTimeBetween(endTime, startTime);
        return ResponseEntity.ok(activities);
    }

    @PostMapping
    @ApiOperation(value = "Add lectures")
    public void addLecture(Lecture activity) {
        lectureService.addActivity(activity);
    }

    @GetMapping(value = "/journal")
    @ApiOperation(value = "Get journal", response = ResponseEntity.class)
    public ResponseEntity<List<LectureDTO>> getJournal() {
        List<LectureDTO> journal = lectureService.getJournal();
        return ResponseEntity.ok(journal);
    }
}
