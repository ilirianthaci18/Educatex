package com.educatex.lms.controller;

import com.educatex.lms.model.Student;
import com.educatex.lms.service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/students")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

//    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
//    public String getStudent(){
//        return "No students";
//    }
//
//    @PostMapping
//    @PreAuthorize("hasAuthority('student:write')")
//    public String registerStudent(){
//        return "NewStudentNotRegistered";
//    }
//
//    @DeleteMapping
//    @PreAuthorize("hasAuthority('student:write')")
//    public String deleteStudent(){
//        return "Student Deleted";
//    }
//

}
