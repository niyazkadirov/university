package com.example.university.controller;


import com.example.university.dto.teacherService.teacherTimeTable.TeacherTimetableDTO;
import com.example.university.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    TeacherService teacherService;

    @GetMapping("timetable")
    ResponseEntity<TeacherTimetableDTO> getTimetable(@RequestParam String firstName,
                                                     @RequestParam String lastName) {
        TeacherTimetableDTO teacherTimetableDTO = teacherService.getTimetable(firstName, lastName);
        return ResponseEntity.ok(teacherTimetableDTO);
    }
}
