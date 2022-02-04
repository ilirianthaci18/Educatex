package com.educatex.lms.controller;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.common.dto.StudentDTOCourse;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Search;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.EnrollService;
import com.educatex.lms.service.StudentService;
import io.jsonwebtoken.lang.Assert;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@CrossOrigin(originPatterns = "*")
@AllArgsConstructor
@RequestMapping("/api/student")
@RestController
public class StudentController {

    private StudentService studentService;
    private EnrollService enrollService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping()
    public List<StudentDTO> getAllStudents() {

        return studentService.getAllStudents();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/{id}")
    public StudentDTO getStudentdById(@PathVariable Long id) {
        return studentService.getStudentDTOById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/firstName/{firstName}")
    public List<StudentDTOCourse> getStudentByFirstName(@PathVariable String firstName) {
        return studentService.findAllByFirstName(firstName);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/lastName/{lastName}")
    public List<StudentDTOCourse> getStudentByLastName(@PathVariable String lastName) {
        return studentService.findAllByLastName(lastName);
    }

    //    localhost:8080/api/student/regularStudents?regular=false you should call this endpoint like this
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/regularStudents")
    public List<StudentDTOCourse> getAllRegularStudents(@RequestParam boolean regular) {
        Assert.notNull(regular, "Regular should not be null");

        return studentService.findAllRegularStudents(regular);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/students/count")
    public Integer getCountStudents() {
        return studentService.countStudents();
    }


    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/search")
    public Search saveSearch(@RequestBody Search search) {
        return studentService.saveSearch(search);
    }

    @PreAuthorize("hasAuthority('student:write')")
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PreAuthorize("hasAuthority('admin:write')")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @GetMapping("/viewAttendence")
    public int viewAttendence(@RequestBody Course course) {
        return studentService.viewAttendence(course);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/scheducle")
    public List<LocalDateTime> orari(@RequestBody @Valid Student student) {
        return studentService.orari(student);
    }

    @PreAuthorize("hasAuthority('student:read')")
    @GetMapping("/studentInfo/{id}")
    public void showStudentInfo(@PathVariable Long id) {
        studentService.showStudentInfo(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT')")
    @GetMapping("/reccomendations")
    public void showReccomentation() {
        studentService.showReccomentation();
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/regular")
    public boolean iRregullt(@RequestBody Student std) {
        return studentService.iRregullt(std);
    }

    @PreAuthorize("hasAuthority('student:write')")
    @PostMapping("/{studentId}/post/{postId}")
    public void addPostToStudent(@PathVariable Long studentId, @PathVariable Long postId) {
        studentService.addPostToStudent(studentId, postId);
    }

    @PreAuthorize("hasAuthority('student:write')")
    @PostMapping("/{studentId}/course/{courseId}/{courseCode}")
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId, @PathVariable String courseCode) {
        enrollService.addStudentToSubject(studentId, courseId, courseCode);
    }
}


