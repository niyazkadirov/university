package com.example.university.controller;

import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
@Api(tags = {"Group"})
public class GroupController {

    private final GroupService groupService;


    @GetMapping(params = "id")
    @ApiOperation(value = "Get all students by group id", response = ResponseEntity.class)
    public ResponseEntity<List<Student>> getAllStudentsByGroupId(@RequestParam() Long id) throws NotFoundException {
        List<Student> students = groupService.getAllStudentsByGroupId(id);
        return ResponseEntity.ok(students);
    }

    @PostMapping()
    @ApiOperation(value = "Add group ")
    public void addGroup(@RequestBody Group group) {
        groupService.addGroup(group);
    }

}
