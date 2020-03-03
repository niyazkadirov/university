package com.example.university.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDTO {
    private String title;
    private String description;

    private List<StudentDTO> studentList;


}
