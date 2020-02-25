package com.example.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long audienceNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "activity", cascade = CascadeType.ALL)
    private Set<Student> students;
}
