package com.example.university.service;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Group;
import com.example.university.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface GroupService {

    ResponseEntity<List<Student>> getAllStudentsByGroupId(Long id) throws ResourceNotFoundException;

    void addGroup(Group group);
}
