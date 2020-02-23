package com.example.university.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE(0),
    FEMALE(1),
    UNDEFINED(2);

    private int code;
}