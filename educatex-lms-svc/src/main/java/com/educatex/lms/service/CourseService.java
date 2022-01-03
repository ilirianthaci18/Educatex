package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;

import java.util.Set;

public interface CourseService {
    boolean isStudentEnrolled(Student student);
    void printCourseInfo(Course course);
}
