package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Student;
import com.example.university.service.StudentService;
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
    public ResponseEntity<Student> getStudentById(@RequestParam Long id) throws ResourceNotFoundException {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getStudentsAgeGreater(@RequestParam(required = false) Long age,
                                                               @RequestParam(required = false) String firstName,
                                                               @RequestParam(required = false, defaultValue = "true") Boolean flag) {
        return studentService.findStudent(age, firstName, flag);
    }

    @PostMapping()
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
}
@PostMapping