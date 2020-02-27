package com.example.university.service;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.repository.GroupRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public Set<Student> getAllStudentsByGroupId(Long id) throws NotFoundException {
        Group group = groupRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
        return group.getStudents();
    }

    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }
}
