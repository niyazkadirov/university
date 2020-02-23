package com.example.university.service;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Group;
import com.example.university.model.Student;
import com.example.university.repository.GroupRepository;
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
    public ResponseEntity<Set<Student>> getAllStudentsByGroupId(Long id) throws ResourceNotFoundException {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student for id" + id + "does not exist"));
        Set<Student> students = group.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Override
    public void addGroup(Group group) {
        groupRepository.save(group);
    }
}
