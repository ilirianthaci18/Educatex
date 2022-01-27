package com.educatex.lms.service;


import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Post;
import com.educatex.lms.model.Student;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentService {

    int viewAttendence(Course course);

    List<LocalDateTime> orari(Student student);

    void showStudentInfo(Long id);

    void showReccomentation();

    boolean iRregullt(Student std);

    Student saveStudent(Student student);

    Student updateStudent(Long id,Student student);

    void deleteStudent(Long id);

    List<StudentDTO> getAllStudents();

    Student getStudentdById(Long id);
    StudentDTO getStudentDTOById(Long id);

    void deleteAllStudents();

    void addCourseToStudent(Long studentId,Long courseId);

    void addPostToStudent(Long studentId,Long postId);


}
