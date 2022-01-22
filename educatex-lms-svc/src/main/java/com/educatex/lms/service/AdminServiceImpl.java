package com.educatex.lms.service;

import com.educatex.lms.model.Admin;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private StudentService studentService;
    private CourseService courseService;
    private ProfessorService professorService;

    @Override
    public Admin addNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void removeAdmin(Admin admin) {
        adminRepository.delete(admin);
    }

    @Override
    public Professor addNewProfessor(Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @Override
    public Professor modifyProfessor(Long id,Professor professor) {
        return professorService.updateProfessor(id,professor);
    }

    @Override
    public void removeProfessor(Professor professor) {
        professorService.deleteProfessor(professor.getId());
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentService.saveStudent(student);
    }

    @Override
    public Student modifyStudent(Long id,Student student) {
        return studentService.updateStudent(id,student);
    }

    @Override
    public Course addNewCourse(Course course) {
        return courseService.saveCourse(course);
    }

    @Override
    public Course modifyCourse(Course course) {
        return courseService.editCourse(course);
    }

    @Override
    public void enrollStudentsForCourse(Student student, Course course) {

    }

    @Override
    public void unenrollStudentsFromCourse(Student student, Course course) {

    }
}
