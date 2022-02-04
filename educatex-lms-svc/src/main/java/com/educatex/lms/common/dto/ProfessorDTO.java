package com.educatex.lms.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long id;

    private String name;

    private String lastName;

    private char gender;

    private int age;

    private Long personalNum;

    private Set<CourseDTOStudent> courses=new HashSet<>();

    @JsonManagedReference
    public Set<CourseDTOStudent> getCourses() {
        return courses;
    }

    public void addCourses(CourseDTOStudent course){
        if(!courses.contains(course)) {
            courses.add(course);
        }
    }
}
