package com.example.university.controller;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.service.GroupService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;


    @GetMapping(params = "id")
    public ResponseEntity<Set<Student>> getAllStudentsByGroupId(@RequestParam() Long id) throws NotFoundException {
        Set<Student> students = groupService.getAllStudentsByGroupId(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping()
    public void addStudent(@RequestBody Group group) {
        groupService.addGroup(group);
    }

}
