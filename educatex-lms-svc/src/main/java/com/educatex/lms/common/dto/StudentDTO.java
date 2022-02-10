package com.educatex.lms.common.dto;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Search;
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

    private boolean iRregullt;

    private Set<CourseDTOStudent> courses;

    private List<PostDTOStudent> posts;

    private List<SearchDTO> searches;

    @JsonManagedReference
    public List<SearchDTO> getSearches() {
        return searches;
    }

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
