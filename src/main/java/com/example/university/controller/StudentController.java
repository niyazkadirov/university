package com.example.university.controller;

import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/id")
    public ResponseEntity<Student> getStudentById(@RequestParam Long id) throws NotFoundException {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getStudentsAgeGreater(@RequestParam(required = false) Long age,
                                                               @RequestParam(required = false) String firstName,
                                                               @RequestParam(required = false, defaultValue = "true") Boolean sortedFlag) {
        return studentService.findStudent(age, firstName, sortedFlag);
    }

    @PostMapping()
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
}