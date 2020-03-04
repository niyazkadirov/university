package com.example.university.repository;

import com.example.university.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(LocalTime startTime, LocalTime endTime);
}
