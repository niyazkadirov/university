package com.example.university.service;

import com.example.university.entity.Activity;
import com.example.university.entity.Student;
import com.example.university.repository.ActivityRepository;
import org.junit.Assert;
import org.junit.Before;
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
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ActivityServiceImplTest {

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private ActivityServiceImpl activityService;

    private List<Activity> activityList = new ArrayList<>();


    @BeforeEach
    void initActivityList() {
        Activity activity1 = new Activity();
        activity1.setStartTime(LocalTime.of(9, 0));
        activity1.setEndTime(LocalTime.of(10, 20));

        Activity activity2 = new Activity();
        activity2.setStartTime(LocalTime.of(11, 0));
        activity2.setEndTime(LocalTime.of(12, 20));

        Activity activity3 = new Activity();
        activity3.setStartTime(LocalTime.of(13, 0));
        activity3.setEndTime(LocalTime.of(14, 20));

        activityList.add(activity1);
        activityList.add(activity2);
        activityList.add(activity3);

        Mockito.when(activityRepository.findAll()).thenReturn(activityList);
    }


    @Test
    void getAllByStartTimeBetween() {
        LocalTime endTime = LocalTime.of(14, 20);
        LocalTime startTime = LocalTime.of(10, 20);

        List<Activity> filteredActivitiesList = activityService.getAllByStartTimeBetween(endTime, startTime);
        Assert.assertEquals(filteredActivitiesList.size(), 2);

        Mockito.verify(activityRepository, Mockito.times(1)).findAll();

    }
}