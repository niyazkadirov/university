package com.example.university.service;

import com.example.university.dto.TeacherTimetableDTO;

public interface TeacherTimetableService {
    TeacherTimetableDTO getTimetable(String firstName, String lastName);
}
