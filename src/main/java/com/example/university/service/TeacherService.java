package com.example.university.service;

import com.example.university.dto.teacherService.TeacherDTO;

public interface TeacherService {

    TeacherDTO getTeacherTimetable(Long teacherId);
}
