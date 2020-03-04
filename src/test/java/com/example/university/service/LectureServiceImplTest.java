package com.example.university.service;

import com.example.university.entity.Lecture;
import com.example.university.repository.LectureRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {

    @Mock
    private LectureRepository lectureRepository;

    @InjectMocks
    private LectureServiceImpl lectureService;

    private List<Lecture> lectureList = new ArrayList<>();


    @BeforeEach
    void initLectureList() {
        Lecture lecture = new Lecture();
        lecture.setStartTime(LocalTime.of(9, 0));
        lecture.setEndTime(LocalTime.of(10, 20));

        Lecture lecture1 = new Lecture();
        lecture1.setStartTime(LocalTime.of(11, 0));
        lecture1.setEndTime(LocalTime.of(12, 20));

        Lecture lecture2 = new Lecture();
        lecture2.setStartTime(LocalTime.of(13, 0));
        lecture2.setEndTime(LocalTime.of(14, 20));

        lectureList.add(lecture);
        lectureList.add(lecture1);
        lectureList.add(lecture2);

        Mockito.when(lectureRepository.findAll()).thenReturn(lectureList);
    }


    @Test
    void getAllByStartTimeBetween() {
        LocalTime endTime = LocalTime.of(14, 20);
        LocalTime startTime = LocalTime.of(10, 20);

        List<Lecture> filteredActivitiesList = lectureService.getAllByStartTimeBetween(endTime, startTime);
        Assert.assertEquals(filteredActivitiesList.size(), 2);

        Mockito.verify(lectureRepository, Mockito.times(1)).findAll();
    }
}