package com.example.university.service;

import com.example.university.dto.LectureDTO;
import com.example.university.entity.Activity;

import java.time.LocalTime;
import java.util.List;

public interface ActivityService {

    List<Activity> getAllActivity();

    List<Activity> getAllByStartTimeBetween(LocalTime startTime, LocalTime endTime);

    void addActivity(Activity activity);

    public List<LectureDTO> getJournal();
}
