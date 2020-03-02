package com.example.university.dto;

import com.example.university.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class GroupDTO {
    private String title;
    private String description;

    private List<StudentDTO> studentList;


}
