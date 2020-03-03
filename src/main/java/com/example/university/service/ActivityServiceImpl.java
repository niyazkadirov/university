package com.example.university.service;

import com.example.university.dto.GroupDTO;
import com.example.university.dto.LectureDTO;
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
    public List<LectureDTO> getJournal() {
        List<Activity> activities = activityRepository.findAll();
        List<LectureDTO> lectureDTOList = new ArrayList<>();

        for (Activity activity : activities) {
            LectureDTO lectureDTO = modelMapper.map(activity, LectureDTO.class);
            lectureDTO.setDuration(Duration.between(activity.getEndTime(), activity.getStartTime()));

            List<GroupDTO> groupDTOList = new ArrayList<>();

            for (Group group : activity.getGroups()) {
                GroupDTO groupDTO = modelMapper.map(group, GroupDTO.class);

                List<StudentDTO> studentDTOList = new ArrayList<>();
                for (Student student : group.getStudents()) {
                    StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
                    studentDTOList.add(studentDTO);
                }

                groupDTO.setStudentList(studentDTOList);
                groupDTOList.add(groupDTO);
            }
            
            lectureDTO.setGroupDTO(groupDTOList);
            lectureDTOList.add(lectureDTO);
        }
        return lectureDTOList;
    }
}
