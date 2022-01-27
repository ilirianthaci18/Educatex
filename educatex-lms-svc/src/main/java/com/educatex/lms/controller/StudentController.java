package com.educatex.lms.controller;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@RequestMapping("/api/student")
@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getAllStudents(){

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentdById(@PathVariable Long id){
        return studentService.getStudentDTOById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @GetMapping("/viewAttendence")
    public int viewAttendence(@RequestBody Course course){
        return studentService.viewAttendence(course);
    }

    @GetMapping("/scheducle")
    public List<LocalDateTime> orari(@RequestBody @Valid Student student){
        return  studentService.orari(student);
    }

    @GetMapping("/studentInfo/{id}")
    public void showStudentInfo(@PathVariable Long id){
        studentService.showStudentInfo(id);
    }

    @GetMapping("/reccomendations")
    public void showReccomentation(){
        studentService.showReccomentation();
    }

    @GetMapping("/regular")
    public boolean iRregullt(@RequestBody Student std){
        return studentService.iRregullt(std);
    }

    @PostMapping("/{studentId}/course/{courseId}")
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        studentService.addCourseToStudent(studentId,courseId);
    }

    @PostMapping("/{studentId}/post/{postId}")
    public void addPostToStudent(@PathVariable Long studentId, @PathVariable Long postId){
        studentService.addPostToStudent(studentId,postId);
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


