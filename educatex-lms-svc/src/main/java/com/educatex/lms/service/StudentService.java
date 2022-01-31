package com.educatex.lms.service;


import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.common.dto.StudentDTOCourse;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Post;
import com.educatex.lms.model.Search;
import com.educatex.lms.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentService {

    int viewAttendence(Course course);

    List<LocalDateTime> orari(Student student);

    String showStudentInfo(Long id);

    void showReccomentation();

    boolean iRregullt(Student std);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    List<StudentDTO> getAllStudents();

    Student getStudentdById(Long id);

    StudentDTO getStudentDTOById(Long id);

    void deleteAllStudents();

    void addPostToStudent(Long studentId, Long postId);

    void addSearchToStudent(Long studentId, Long searchId);

    Search saveSearch(Search search);

    List<StudentDTOCourse> findAllByFirstName(String firstName);

    List<StudentDTOCourse> findAllByLastName(String name);

    List<StudentDTOCourse> findAllRegularStudents(boolean rregullt);

    Integer countStudents();

}
