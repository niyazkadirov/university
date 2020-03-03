package com.example.university.service;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import javassist.NotFoundException;

import java.util.List;
import java.util.Set;

public interface GroupService {

    List<Student> getAllStudentsByGroupId(Long id) throws  NotFoundException;

    void addGroup(Group group);
}
