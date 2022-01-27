package com.educatex.lms.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ElibraryDTO {

    private String name;

    private Set<TrainingDTOElibrary> trainings=new HashSet<>();

    private Set<StudentDTOCourse> students=new HashSet<>();

    private Set<BookDTOCourse> books;

    private Set<AssignmentDTO> assignments=new HashSet<>();


    @JsonManagedReference
    public Set<TrainingDTOElibrary> getTrainings() {
        return trainings;
    }

    @JsonManagedReference
    public Set<StudentDTOCourse> getStudents() {
        return students;
    }

    @JsonManagedReference
    public Set<BookDTOCourse> getBooks() {
        return books;
    }

    @JsonManagedReference
    public Set<AssignmentDTO> getAssignments() {
        return assignments;
    }
}
