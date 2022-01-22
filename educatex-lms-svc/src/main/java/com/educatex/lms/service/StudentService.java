package com.educatex.lms.service;


import com.educatex.lms.model.Course;
import com.educatex.lms.model.Student;

import java.util.List;

public interface StudentService {

    int viewAttendence(Course course);

    void orari();

    void showStudentInfo(Long id);

    void showReccomentation();

    boolean iRregullt(Student std);

    Student saveStudent(Student student);

    Student updateStudent(Long id,Student student);

    void deleteStudent(Long id);

    List<Student> getAllStudents();

    Student getStudentdById(Long id);

}
