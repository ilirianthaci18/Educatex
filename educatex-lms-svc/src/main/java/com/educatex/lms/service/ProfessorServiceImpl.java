package com.educatex.lms.service;

import com.educatex.lms.exception.NotFoundException;
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

    @Override //todo ProfessorDTO
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElseThrow(() -> {
            log.error("Professor could not be found , id : ", id);
            return new NotFoundException("Professor with id " + id + "not found");
        });
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteAllProfessors(){
        professorRepository.deleteAll();
        log.info("Deleted all professors");
    }

    @Override
    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
        log.info("Deleted professor with id : ",id);
    }

    @Override
    public String showProfessorInfo(Long id) {
        Professor professor=getProfessorById(id);
        return professor.toString();
    }

    @Override
    public Professor searchProfessor(String name) {
        return null;  // TODO SEARCH BY NAME
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
