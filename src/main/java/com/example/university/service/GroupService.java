package com.example.university.service;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import javassist.NotFoundException;

import java.util.List;

public interface GroupService {

    List<Student> getAllStudentsByGroupId(Long id) throws  NotFoundException;

    void addGroup(Group group);
}
