package com.example.university.controller;

import com.example.university.dto.studentService.studentTimetable.StudentDTO;
import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Api(tags = {"Student"})
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/id")
    @ApiOperation(value = "Get student by id", response = ResponseEntity.class)
    public ResponseEntity<Optional<Student>> getStudentById(@RequestParam Long id) throws NotFoundException {
        Optional<Student> student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "Get students age greater", response = ResponseEntity.class)
    public ResponseEntity<List<Student>> getStudentsAgeGreater(@RequestParam(required = false) Long age,
                                                               @RequestParam(required = false) String firstName,
                                                               @RequestParam(required = false, defaultValue = "true") Boolean sortedFlag) {
        List<Student> students = studentService.findAndSortedStudentByParams(age, firstName, sortedFlag);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @ApiOperation(value = "Add student")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping(value = "/sorted")
    @ApiOperation(value = "Get all students by gender code", response = ResponseEntity.class)
    public ResponseEntity<List<Student>> getAllStudentsByGenderCode(@RequestParam Integer genderCode) {
        List<Student> students = studentService.getAllStudentsByGenderCode(genderCode);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/timetable")
    @ApiOperation(value = "Get student timetable", response = ResponseEntity.class)
    public StudentDTO getStudentTimetable(@RequestParam String firstName,
                                          @RequestParam String lastName) {
        return studentService.getStudentTimetable(firstName, lastName);
    }
}