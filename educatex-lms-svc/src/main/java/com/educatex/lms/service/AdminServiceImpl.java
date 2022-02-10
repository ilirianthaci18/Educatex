package com.educatex.lms.service;

import com.educatex.lms.model.*;
import com.educatex.lms.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

//@AllArgsConstructor
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private StudentService studentService;
    private CourseService courseService;
    private ProfessorService professorService;
    private EnrollService enrollService;

    public AdminServiceImpl(AdminRepository adminRepository, StudentService studentService, CourseService courseService, ProfessorService professorService, EnrollService enrollService) {
        this.adminRepository = adminRepository;
        this.studentService = studentService;
        this.courseService = courseService;
        this.professorService = professorService;
        this.enrollService = enrollService;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin addNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void removeAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Professor addNewProfessor(Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @Override
    public Professor modifyProfessor(Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @Override
    public void removeProfessor(Long id) {
        professorService.deleteProfessor(id);
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentService.saveStudent(student);
    }

    @Override
    public Student modifyStudent(Student student) {
        return studentService.saveStudent(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentService.deleteStudent(id);
    }

    @Override
    public Course addNewCourse(Course course) {
        return courseService.saveCourse(course);
    }

    @Override
    public Course modifyCourse(Course course) {
        return courseService.saveCourse(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseService.deleteCourse(id);
    }

    @Override
    public void enrollStudentsForCourse(Student student, Course course) {
        enrollService.addStudentToSubject(course.getId(),student.getId(),"asd");
    }

    @Override
    public void unenrollStudentsFromCourse(Student student, Course course) {
        enrollService.unEnrollStudentFromSubject(course.getId(),student.getId());
    }

    @Override
    public List<Admin> findAllByFirstName(String firstName) {
        return adminRepository.findAllByFirstName(firstName);
    }

    @Override
    public Integer countAdmins() {
        return adminRepository.countAdmins();
    }

}
