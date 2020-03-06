package com.example.university.service;

import com.example.university.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImp implements SubjectService {

    private final GroupRepository groupRepository;

}
