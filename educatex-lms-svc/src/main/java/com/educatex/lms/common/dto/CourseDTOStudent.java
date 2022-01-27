package com.educatex.lms.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTOStudent {

    private Long id;

    private String courseName;

    private String courseCode;

    private int ects;

}
