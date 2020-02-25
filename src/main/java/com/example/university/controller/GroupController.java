package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Group;
import com.example.university.model.Student;
import com.example.university.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;


    @GetMapping(params = "id")
    public ResponseEntity<Set<Student>> getAllStudentsByGroupId(@RequestParam() Long id) throws ResourceNotFoundException {
        return groupService.getAllStudentsByGroupId(id);
    }

    @PostMapping()
    public void addStudent(@RequestBody Group group) {
        groupService.addGroup(group);
    }

}
