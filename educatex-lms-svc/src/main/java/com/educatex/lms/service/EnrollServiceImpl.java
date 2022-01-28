package com.educatex.lms.service;

import com.educatex.lms.exception.ApiRequestException;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class EnrollServiceImpl implements EnrollService {
    private CourseService courseService;
    private StudentService studentService;
    private ProfessorService professorService;

    @Override
    public void addStudentToSubject(Long studentId, Long courseId, String courseCode) {
        Student student=studentService.getStudentdById(studentId);
        Course course=courseService.getCourseById(courseId);
        if(course.getCourseCode().equals(courseCode)) {
            student.getCourses().add(course);
            studentService.saveStudent(student);
        }else{
            log.error("Course code is invalid : ",courseCode);
            throw new ApiRequestException("Course code : "+courseCode+" is invalid");
        }

        log.info("Student enrolled one course ",student,course);
    }

    @Override
    public void assignProfessorToSubject(Long courseId, Long professorId) {
        Course course = courseService.getCourseById(courseId);
        Professor professor = professorService.getProfessorById(professorId);

        course.setProfessor(professor);

        courseService.saveCourse(course);

        log.info("Course with professor saved successfully", course, professor);
    }

    @Override
    public void unEnrollStudentFromSubject(Long courseId, Long studentId) {
        Course course = courseService.getCourseById(courseId);

        Student student = studentService.getStudentdById(studentId);

        course.getEnrolledStudents().remove(student);

        courseService.saveCourse(course);

        log.info("Course successfully removed student", course, student);
    }

}
