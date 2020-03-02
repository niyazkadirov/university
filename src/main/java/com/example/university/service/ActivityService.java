package com.example.university.service;

import com.example.university.dto.LectureDTO;
import com.example.university.entity.Activity;
import com.example.university.entity.Student;
import javassist.NotFoundException;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface ActivityService {

    List<Activity> getAllActivity();

    List<Activity> getAllByStartTimeBetween(LocalTime startTime, LocalTime endTime);

    void addActivity(Activity activity);

    public List<LectureDTO> getJournal();
}
