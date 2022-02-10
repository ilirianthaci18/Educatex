package com.educatex.lms.service;

import com.educatex.lms.common.dto.ProfessorDTO;
import com.educatex.lms.common.dto.ProfessorDTOCourse;
import com.educatex.lms.exception.NotFoundException;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.educatex.lms.common.mappers.ProfessorMapper.*;

//@AllArgsConstructor
@Slf4j
@Service
public class ProfessorServiceImpl implements ProfessorService{

    private ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        List<Professor> professors= professorRepository.findAll();
        List<ProfessorDTO> professorDTOS=new ArrayList<>();

        professors.stream().forEach(professor -> {
            professorDTOS.add(professorDTO(professor));
        });

        return professorDTOS;
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
    public List<ProfessorDTOCourse> searchProfessor(String name) {
        List<Professor> professors=professorRepository.findAllByFirstName(name);

        return professors.stream().map(professor -> {
            return professorToCourse(professor);
        }).collect(Collectors.toList());
    }

    @Override
    public boolean iRregullt(Professor professor) {
        return false;
    }

    @Override
    public Set<Student> viewAttendance(Course course) {
        return null;
    }

    @Override
    public Integer countProfessors() {
        return professorRepository.countProfessors();
    }


}
