package com.example.university.controller;

import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/id")
    public ResponseEntity<Optional<Student>> getStudentById(@RequestParam Long id) throws NotFoundException {
        Optional<Student> student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getStudentsAgeGreater(@RequestParam(required = false) Long age,
                                                               @RequestParam(required = false) String firstName,
                                                               @RequestParam(required = false, defaultValue = "true") Boolean sortedFlag) {
        List<Student> students = studentService.findStudent(age, firstName, sortedFlag);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}