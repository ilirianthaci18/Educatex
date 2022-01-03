package com.educatex.lms.service;

import com.educatex.lms.model.Admin;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;

public interface AdminService {
    Admin addNewAdmin(Admin admin);

    void removeAdmin(Admin admin);

    Professor addNewProfessor(Professor professor);

    void modifyProfessor(Professor professor);

    void removeProfessor(Professor professor);

    Student addNewStudent(Student student);

    void modifyStudent(Student student);

    Course addNewCourse(Course course);

    void modifyCourse(Course course);

    void enrollStudentsForCourse(Student student,Course course);

    void unenrollStudentsFromCourse(Student student,Course course);
}
