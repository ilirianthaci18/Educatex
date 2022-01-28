package com.educatex.lms.service;

import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface CourseService {
    boolean isStudentEnrolled(Long courseId,Student student);
    void printCourseInfo(Course course);
    Professor courseProfessor(Long courseId);
    List<CourseDTO> getCourses();
    CourseDTO findCourseById(Long id);
    Course findCourseId(Long id);
    Course saveCourse(Course course);
    Course getCourseById(Long id);
    void deleteCourse(Long id);
//    void addStudentToSubject(Long courseId,Long studentId,String courseCode);
//    void assignProfessorToSubject(Long courseId,Long professorId);
    void assignBookToCourse(Long courseId,Long bookId);
    void deleteAllCourses();
}
