package com.educatex.lms.service;

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
    List<Course> getCourses();
    Course findCourseById(Long id);
    Course saveCourse(Course course);
    Course editCourse(Course course);
    void deleteCourse(Long id);
    Course addStudentToSubject(Long courseId,Long studentId,String courseCode);
    Course assignProfessorToSubject(Long courseId,Long professorId);

}
