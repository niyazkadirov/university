package com.example.university.service;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.repository.GroupRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;


    @Override
    public List<Student> getAllStudentsByGroupId(Long id) throws NotFoundException {
        Group group = groupRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
        return group.getStudents();
    }

    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }
}
