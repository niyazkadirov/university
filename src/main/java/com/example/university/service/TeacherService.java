package com.example.university.service;

import com.example.university.dto.teacherService.teacherTimetable.TeacherDTO;

public interface TeacherService {

    TeacherDTO getTeacherTimetable(Long teacherId);
}
