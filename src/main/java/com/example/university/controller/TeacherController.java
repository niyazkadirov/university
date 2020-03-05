package com.example.university.controller;

import com.example.university.dto.teacherService.teacherTimetable.TeacherDTO;
import com.example.university.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
@Api(tags = {"Teacher"})
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/timetable")
    @ApiOperation(value = "Get teacher timetable", response = ResponseEntity.class)
    public ResponseEntity<TeacherDTO> getTeacherTimetable(@RequestParam Long id) {
        TeacherDTO teacherTimetable = teacherService.getTeacherTimetable(id);
        return ResponseEntity.ok(teacherTimetable);
    }

}