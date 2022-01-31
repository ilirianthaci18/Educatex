package com.educatex.lms.controller;

import com.educatex.lms.common.dto.ProfessorDTOCourse;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/api/professor")
@RestController
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping()//todo ProfessorDTO
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @DeleteMapping("/all")
    public void deleteAllProfessors(){
       professorService.deleteAllProfessors();
    }

    @PostMapping()
    public Professor saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @PutMapping()
    public Professor updateProfessor( @RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @GetMapping("/professorInfo/{id}")
    public void showProfessorInfo(@PathVariable Long id) {
        professorService.showProfessorInfo(id);
    }

    @GetMapping("/{name}") //TODO test
    public List<ProfessorDTOCourse> searchProfessor(@PathVariable String name) {
        return professorService.searchProfessor(name);
    }

    @GetMapping("/countProfessors") // TODO test
    public Integer countProfessors(){
        return professorService.countProfessors();
    }

    @GetMapping("/regular")
    public boolean iRregullt(@RequestBody Professor professor) {
        return professorService.iRregullt(professor);
    }

    @GetMapping("/viewAttendance")
    public Set<Student> viewAttendance(@RequestBody Course course) {
        return professorService.viewAttendance(course);
    }
}
