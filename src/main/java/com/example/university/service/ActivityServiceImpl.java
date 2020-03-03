package com.example.university.service;

import com.example.university.dto.ActivityDTO;
import com.example.university.dto.StudentDTO;
import com.example.university.entity.Activity;
import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<Activity> getAllActivity() {
        return activityRepository.findAll();
    }

    @Override
    public List<Activity> getAllByStartTimeBetween(LocalTime endTime, LocalTime startTime) {
        List<Activity> activities = activityRepository.findAll();

        return activities
                .stream()
                .filter(activity -> activity.getStartTime().isBefore(endTime) & activity.getEndTime().isAfter(startTime))
                .collect(Collectors.toList());
    }

    @Override
    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }


    @Override
    public List<ActivityDTO> getJournal() {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDTO> activityDTOList = new ArrayList<>();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Activity activity : activities) {
            ActivityDTO activityDTO = modelMapper.map(activity, ActivityDTO.class);
            activityDTO.setStudentDTO(studentDTOList);
            activityDTO.setDuration(Duration.between(activity.getEndTime(), activity.getStartTime()));

            for (Group group : activity.getGroups()) {
                List<Student> students = group.getStudents();
                for (Student student : students) {
                    StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
                    studentDTOList.add(studentDTO);
                }
            }

            activityDTOList.add(activityDTO);
        }
        return activityDTOList;
    }
}
