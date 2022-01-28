package com.educatex.lms.service;

public interface EnrollService {
    void addStudentToSubject(Long courseId,Long studentId,String courseCode);
    void assignProfessorToSubject(Long courseId, Long professorId);
    void unEnrollStudentFromSubject(Long courseId,Long studentId);
}
