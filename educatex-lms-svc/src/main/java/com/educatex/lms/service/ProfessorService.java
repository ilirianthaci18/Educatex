package com.educatex.lms.service;

import com.educatex.lms.common.dto.ProfessorDTOCourse;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ProfessorService {

    Professor saveProfessor(Professor professor);

    void deleteProfessor(Long id);

    List<Professor> getAllProfessors();

    Professor getProfessorById(Long id);

    String showProfessorInfo(Long id);

    List<ProfessorDTOCourse> searchProfessor(String name);

    boolean iRregullt(Professor professor);

    Set<Student> viewAttendance(Course course);

    void deleteAllProfessors();

    Integer countProfessors();
}
