package com.example.university.service;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Group;
import com.example.university.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface GroupService {

    ResponseEntity<Set<Student>> getAllStudentsByGroupId(Long id) throws ResourceNotFoundException;

    void addGroup(Group group);
}
