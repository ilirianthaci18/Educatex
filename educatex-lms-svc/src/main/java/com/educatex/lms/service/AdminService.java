package com.educatex.lms.service;

import com.educatex.lms.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

    Admin addNewAdmin(Admin admin);

    void removeAdmin(Long id);

    Professor addNewProfessor(Professor professor);

    Professor modifyProfessor(Professor professor);

    void removeProfessor(Long id);

    Student addNewStudent(Student student);

    Student modifyStudent(Student student);

    void removeStudent(Long id);

    Course addNewCourse(Course course);

    Course modifyCourse(Course course);

    void deleteCourse(Long id);

    void enrollStudentsForCourse(Student student, Course course);

    void unenrollStudentsFromCourse(Student student, Course course);

    List<Admin> findAllByFirstName(String firstName);

    Integer countAdmins();
}
