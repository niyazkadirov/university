package com.example.university.repository;

import com.example.university.model.Activity;
import com.example.university.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {



    List<Activity> findAllByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(LocalDateTime startTime, LocalDateTime endTime);

}
