package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Slf4j
@Service
public class ProfessorServiceImpl implements ProfessorService{

    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).get();
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor updateProfessor(Long id, Professor professor) {
        Professor professor1=getProfessorById(id);

        //here should impl objectMapper
        return professor1;
    }

    @Override
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public void showProfessorInfo(Long id) {
        Professor professor=getProfessorById(id);

        log.info("Professor info ",professor.toString());
    }

    @Override
    public Professor searchProfessor(String name) {
        return null;
    }

    @Override
    public boolean iRregullt(Professor professor) {
        return false;
    }

    @Override
    public Set<Student> viewAttendance(Course course) {
        return null;
    }
}
