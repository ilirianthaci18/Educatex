package com.educatex.lms.service;

import com.educatex.lms.model.Admin;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

    Admin addNewAdmin(Admin admin);

    void removeAdmin(Long id);

    Professor addNewProfessor(Professor professor);

    Professor modifyProfessor(Long id, Professor professor);

    void removeProfessor(Long id);

    Student addNewStudent(Student student);

    Student modifyStudent(Long id, Student student);

    void removeStudent(Long id);

    Course addNewCourse(Course course);

    Course modifyCourse(Long id, Course course);

    void deleteCourse(Long id);

    void enrollStudentsForCourse(Student student, Course course);

    void unenrollStudentsFromCourse(Student student, Course course);
}
