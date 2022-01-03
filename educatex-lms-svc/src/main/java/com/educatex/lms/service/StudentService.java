package com.educatex.lms.service;


import com.educatex.lms.model.Course;
import com.educatex.lms.model.Student;

public interface StudentService {
    int viewAttendence(Course course);

    void orari();

    void showStudentInfo(Long id);

    void showReccomentation();

    boolean iRregullt(Student std);


}
