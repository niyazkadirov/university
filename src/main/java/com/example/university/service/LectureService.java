package com.example.university.service;

import com.example.university.dto.LectureDTO;
import com.example.university.entity.Lecture;

import java.time.LocalTime;
import java.util.List;

public interface LectureService {

    List<Lecture> getAllActivity();

    List<Lecture> getAllByStartTimeBetween(LocalTime startTime, LocalTime endTime);

    void addActivity(Lecture activity);

    public List<LectureDTO> getJournal();
}
