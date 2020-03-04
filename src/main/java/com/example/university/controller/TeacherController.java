package com.example.university.controller;

import com.example.university.dto.teacherService.teacherTimetable.TeacherDTO;
import com.example.university.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/timetable")
    public TeacherDTO getTeacherTimetable(@RequestParam Long id) {
        return teacherService.getTeacherTimetable(id);
    }

}
