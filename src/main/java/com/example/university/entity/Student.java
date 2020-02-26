package com.example.university.entity;

import com.example.university.entity.enumeration.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "birth_date", columnDefinition = "date")
    private LocalDate birthDate;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Group group;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "activity_id")
    private Activity activity;
}