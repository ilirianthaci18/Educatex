package com.educatex.lms.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTOCourse {
    private Long id; //TODO

    private String name;

    private String lastName;

    private char gender; //TODO

    private int age; //TODO

    private Long personalNum; //TODO

    private LocalDateTime studentCreatedAt; //TODO
}
