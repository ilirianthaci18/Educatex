package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;

import java.util.List;
import java.util.Set;

public interface ProfessorService {

    Professor saveProfessor(Professor professor);

    Professor updateProfessor(Long id,Professor professor);

    void deleteProfessor(Long id);

    List<Professor> getAllProfessors();

    Professor getProfessorById(Long id);

    void showProfessorInfo(Long id);

    Professor searchProfessor(String name);

    boolean iRregullt(Professor professor);

    Set<Student> viewAttendance(Course course);
}
