package com.educatex.lms.common.dto;

import com.educatex.lms.model.Book;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;

    private String courseName;

    private String courseCode;

    private int ects;

    private ProfessorDTOCourse professor;

    private Set<BookDTOCourse> books;

    private Set<StudentDTOCourse> enrolledStudents = new HashSet<>();

    @JsonManagedReference
    public Set<StudentDTOCourse> getEnrolledStudents() {
        return enrolledStudents;
    }

    @JsonManagedReference
    public ProfessorDTOCourse getProfessor() {
        return professor;
    }

    @JsonManagedReference
    public Set<BookDTOCourse> getBooks() {
        return books;
    }
}
