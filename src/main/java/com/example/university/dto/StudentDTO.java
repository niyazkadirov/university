package com.example.university.dto;

import com.example.university.entity.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    private String firstName;
    private String lastName;
    private Group group;
}
