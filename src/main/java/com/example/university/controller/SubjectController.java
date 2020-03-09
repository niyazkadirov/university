package com.example.university.controller;

import com.example.university.service.SubjectService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timetables")
@RequiredArgsConstructor
@Api(tags = {"Subject"})
public class SubjectController {

    private final SubjectService subjectService;

}
