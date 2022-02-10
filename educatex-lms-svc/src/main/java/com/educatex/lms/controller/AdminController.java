package com.educatex.lms.controller;

import com.educatex.lms.model.Admin;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;


@CrossOrigin(originPatterns = "*")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@AllArgsConstructor
@RestController
@RequestMapping("api/admin")
public class AdminController {

    private AdminService adminService;
    private StudentService studentService;
    private CourseService courseService;
    private ElibraryService elibraryService;
    private ProfessorService professorService;
    private ForumService forumService;


    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }


    @GetMapping("/firstName/{firstName}")
    public List<Admin> getAllAdminsByFirstName(@PathVariable String firstName) {
        return adminService.findAllByFirstName(firstName);
    }

    @GetMapping("/countAdmins")
    public Integer getCountAdmins() {
        return adminService.countAdmins();
    }

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.addNewAdmin(admin);
    }

    @PostMapping("/add/professor")
    public Professor saveProfessor(@RequestBody @Valid Professor professor) {
        return adminService.addNewProfessor(professor);
    }

    @PostMapping("/add/student")
    public Student saveStudent(@RequestBody Student student) {
        return adminService.addNewStudent(student);
    }

    @PostMapping("/add/course")
    public Course addCourse(@RequestBody Course course) {
        return adminService.addNewCourse(course);
    }

    @PostMapping("/enroll/student/course")
    public void enrollStudentForCourse(@RequestBody @Valid Student student, @RequestBody @Valid Course course) {
        adminService.enrollStudentsForCourse(student, course);
    }

    @PostMapping("/unenroll/student/course/{id}")
    public void unenrollStudentFromCourse(@RequestBody @Valid Student student, @PathVariable Long id) {
    }

    @PutMapping("/edit/course")
    public Course editCourse(@RequestBody @Valid Course course) {
        return adminService.modifyCourse(course);
    }

    @PutMapping("/edit/student")
    public Student editStudent(@RequestBody @Valid Student student) {
        return adminService.modifyStudent(student);
    }

    @PutMapping("/edit/professor")
    public Professor editProfessor(@RequestBody @Valid Professor professor) {
        return adminService.modifyProfessor(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.removeAdmin(id);
    }

    @DeleteMapping("/delete/professor/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        adminService.removeProfessor(id);
    }

    @DeleteMapping("/delete/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        adminService.removeStudent(id);
    }

    @DeleteMapping("/delete/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        adminService.deleteCourse(id);
    }

    @DeleteMapping("/students")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }

    @DeleteMapping("/assignments")
    public void deleteAllAssignments() {
        elibraryService.deleteAllAssignments();
    }

    @DeleteMapping("/books")
    public void deleteAllBooks() {
        elibraryService.deleteAllBooks();
    }

    @DeleteMapping("/course")
    public void deleteAllCourse() {
        courseService.deleteAllCourses();
    }

    @DeleteMapping("/post")
    public void deleteAllPost() {
        forumService.deleteAllPosts();
    }

    @DeleteMapping("/professor")
    public void deleteAllProfessor() {
        professorService.deleteAllProfessors();
    }

    @DeleteMapping("/ratings")
    public void deleteAllRatings() {
        elibraryService.deleteAllRatings();
    }

    @DeleteMapping("/replies")
    public void delete() {
        forumService.deleteAllReply();
    }

    @DeleteMapping("/trainings")
    public void deleteAllTrainings() {
        elibraryService.deleteAllTrainings();
    }
}
