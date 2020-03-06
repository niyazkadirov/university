package com.example.university.service;

import com.example.university.dto.teacherService.teacherTimeTable.TeacherTimetableDTO;

public interface TeacherService {
    TeacherTimetableDTO getTimetable(String firstName, String lastName);
}
