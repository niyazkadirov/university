package com.example.university.controller;

import com.example.university.dto.LectureDTO;
import com.example.university.entity.Lecture;
import com.example.university.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/")
    public ResponseEntity<List<Lecture>> getAllLectures() {
        List<Lecture> activities = lectureService.getAllActivity();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }


    @GetMapping("/date")
    public ResponseEntity<List<Lecture>> getAllByStartTimeBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {
        List<Lecture> activities = lectureService.getAllByStartTimeBetween(endTime, startTime);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PostMapping
    public void addLecture(Lecture activity) {
        lectureService.addActivity(activity);
    }

    @GetMapping(value = "/journal")
    public ResponseEntity<List<LectureDTO>> getJournal() {
        List<LectureDTO> journal = lectureService.getJournal();
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }
}
