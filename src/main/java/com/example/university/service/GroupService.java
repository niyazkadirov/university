package com.example.university.service;

import com.example.university.model.Group;
import com.example.university.model.Student;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface GroupService {

    ResponseEntity<Set<Student>> getAllStudentsByGroupId(Long id) throws  NotFoundException;

    void addGroup(Group group);
}
