package com.example.university.controller;

import com.example.university.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetables")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

}
