package com.educatex.lms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("management/api/students")
public class StudentController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    public String getStudent(){
        return "No students";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public String registerStudent(){
        return "NewStudentNotRegistered";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('student:write')")
    public String deleteStudent(){
        return "Student Deleted";
    }
}
