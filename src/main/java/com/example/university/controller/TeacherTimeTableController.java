package com.example.university.controller;


import com.example.university.dto.TeacherTimetableDTO;
import com.example.university.service.TeacherTimetableService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherTimeTableController {

    TeacherTimetableService teacherTimetableService;

    @GetMapping("timetable")
    ResponseEntity<TeacherTimetableDTO> getTimetable(@RequestParam String firstName,
                                                    @RequestParam String LastName){
        TeacherTimetableDTO teacherTimetableDTO=teacherTimetableService.getTimetable(firstName, LastName);
        return ResponseEntity.ok(teacherTimetableDTO);
    }
}
