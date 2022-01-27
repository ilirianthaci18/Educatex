package com.educatex.lms.common.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTOCourse {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name,String lastname) {
        this.name = name+lastname;
    }
}
