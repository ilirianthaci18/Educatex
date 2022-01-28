package com.educatex.lms.controller;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.EnrollService;
import com.educatex.lms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@RequestMapping("/api/student")
@RestController
public class StudentController {

    private StudentService studentService;
    private EnrollService enrollService;

    @GetMapping()
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    public List<StudentDTO> getAllStudents(){

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentdById(@PathVariable Long id){
        return studentService.getStudentDTOById(id);
    }

    @PostMapping
    //    @PreAuthorize("hasAuthority('student:write')")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    //    @PreAuthorize("hasAuthority('student:write')")
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

    @PostMapping("/{studentId}/post/{postId}")
    public void addPostToStudent(@PathVariable Long studentId, @PathVariable Long postId){
        studentService.addPostToStudent(studentId,postId);
    }

    @PostMapping("/{studentId}/course/{courseId}/{courseCode}")
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId,@PathVariable String courseCode){
        enrollService.addStudentToSubject(studentId,courseId,courseCode);
    }

}


