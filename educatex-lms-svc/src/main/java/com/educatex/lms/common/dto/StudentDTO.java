package com.educatex.lms.common.dto;

import com.educatex.lms.model.Course;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;

    private String name;

    private String lastName;

    private char gender;

    private int age;

    private Long personalNum;

    private LocalDateTime studentCreatedAt;

    private Set<CourseDTOStudent> courses=new HashSet<>();

    private List<PostDTOStudent> posts=new ArrayList<>();

    @JsonManagedReference
    public Set<CourseDTOStudent> getCourses() {
        return courses;
    }

    @JsonManagedReference
    public List<PostDTOStudent> getPosts() {
        return posts;
    }

    public void addCourses(CourseDTOStudent course){
        if(!courses.contains(course)) {
            courses.add(course);
        }
    }

}
