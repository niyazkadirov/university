package com.example.university.service;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface GroupService {

    Set<Student> getAllStudentsByGroupId(Long id) throws  NotFoundException;

    void addGroup(Group group);
}
