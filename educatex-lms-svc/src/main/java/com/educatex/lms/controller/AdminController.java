package com.educatex.lms.controller;

import com.educatex.lms.model.Admin;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;


@RestController
@RequestMapping("api/admin")
public class AdminController {

    private AdminService adminService;
    private StudentService studentService;
    private CourseService courseService;
    private ElibraryService elibraryService;
    private ProfessorService professorService;
    private ForumService forumService;
    private DatabaseIntialization databaseIntialization;

    public AdminController(AdminService adminService, StudentService studentService, CourseService courseService, ElibraryService elibraryService, ProfessorService professorService, ForumService forumService, DatabaseIntialization databaseIntialization) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.courseService = courseService;
        this.elibraryService = elibraryService;
        this.professorService = professorService;
        this.forumService = forumService;
        this.databaseIntialization = databaseIntialization;
    }

    @GetMapping("/databaseInitialization")
    public void initializeDatabase(){
        databaseIntialization.initDB();
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.addNewAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.removeAdmin(id);
    }

    @PostMapping("/add/professor")
    public Professor saveProfessor(@RequestBody @Valid Professor professor) {
        return adminService.addNewProfessor(professor);
    }

    @PutMapping("/edit/professor/{id}")
    public Professor editProfessor(@PathVariable Long id,@RequestBody @Valid Professor professor){
        return adminService.modifyProfessor(id,professor);
    }

    @DeleteMapping("/delete/professor/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        adminService.removeProfessor(id);
    }

    @PostMapping("/add/student")
    public Student saveStudent(@RequestBody Student student) {
        return adminService.addNewStudent(student);
    }

    @PutMapping("/edit/student/{id}")
    public Student editStudent(@PathVariable Long id,@RequestBody @Valid Student student){
        return adminService.modifyStudent(id,student);
    }

    @DeleteMapping("/delete/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        adminService.removeStudent(id);
    }

    @PostMapping("/add/course")
    public Course addCourse(@RequestBody Course course) {
        return adminService.addNewCourse(course);
    }

    @DeleteMapping("/delete/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        adminService.deleteCourse(id);
    }

    @PutMapping("/edit/course/{id}")
    public Course editCourse(@PathVariable Long id,@RequestBody @Valid Course course){
        return adminService.modifyCourse(id,course);
    }

    @PostMapping("/enroll/student/course/{id}")
    public void enrollStudentForCourse(@RequestBody @Valid Student student,@PathVariable Long id){

    }

    @PostMapping("/unenroll/student/course/{id}")
    public void unenrollStudentFromCourse(@RequestBody @Valid Student student,@PathVariable Long id){}

    @DeleteMapping("/students")
    public void deleteAllStudents(){
        studentService.deleteAllStudents();
    }

    @DeleteMapping("/assignments")
    public void deleteAllAssignments(){
        elibraryService.deleteAllAssignments();
    }

    @DeleteMapping("/books")
    public void deleteAllBooks(){
        elibraryService.deleteAllBooks();
    }

    @DeleteMapping("/course")
    public void deleteAllCourse(){
        courseService.deleteAllCourses();
    }

    @DeleteMapping("/post")
    public void deleteAllPost(){
        forumService.deleteAllPosts();
    }

    @DeleteMapping("/professor")
    public void deleteAllProfessor(){
        professorService.deleteAllProfessors();
    }

    @DeleteMapping("/ratings")
    public void deleteAllRatings(){
        elibraryService.deleteAllRatings();
    }

    @DeleteMapping("/replies")
    public void delete(){
        forumService.deleteAllReply();
    }

    @DeleteMapping("/trainings")
    public void deleteAllTrainings(){
        elibraryService.deleteAllTrainings();
    }
}
