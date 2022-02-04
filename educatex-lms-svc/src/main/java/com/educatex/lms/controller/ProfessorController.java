package com.educatex.lms.controller;

import com.educatex.lms.common.dto.ProfessorDTO;
import com.educatex.lms.common.dto.ProfessorDTOCourse;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.ProfessorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(originPatterns = "*")
@RequestMapping("/api/professor")
@RestController
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping()
    public List<ProfessorDTO> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/all")
    public void deleteAllProfessors(){
       professorService.deleteAllProfessors();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @PostMapping()
    public Professor saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @PutMapping()
    public Professor updateProfessor( @RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/professorInfo/{id}")
    public void showProfessorInfo(@PathVariable Long id) {
        professorService.showProfessorInfo(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/{name}")
    public List<ProfessorDTOCourse> searchProfessor(@PathVariable String name) {
        return professorService.searchProfessor(name);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/countProfessors")
    public Integer countProfessors(){
        return professorService.countProfessors();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/regular")
    public boolean iRregullt(@RequestBody Professor professor) {
        return professorService.iRregullt(professor);
    }

    @PreAuthorize("hasAnyRole('ROLE_PROFESSOR')")
    @GetMapping("/viewAttendance")
    public Set<Student> viewAttendance(@RequestBody Course course) {
        return professorService.viewAttendance(course);
    }
}
