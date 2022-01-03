package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;

import java.util.Set;

public interface ProfessorService {
    void showProfessorInfo(Long id);

    Professor searchProfessor(String name);

    boolean iRregullt(Professor professor);

    Set<Student> viewAttendance(Course course);
}
