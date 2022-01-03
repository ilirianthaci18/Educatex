package com.educatex.lms.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

//    @PostMapping("/{subjectId}/students/{studentId}")
//    Subject addStudentToSubject(
//            @PathVariable Long subjectId,
//            @PathVariable Long studentId
//    ) {
//        Subject subject = subjectRepository.findById(subjectId).get();
//        Student student = studentRepository.findById(studentId).get();
//        subject.enrolledStudents.add(student);
//        return subjectRepository.save(subject);
//    }
//
//    @PostMapping("/{subjectId}/teacher/{teacherId}")
//    Subject assignTeacherToSubject(
//            @PathVariable Long subjectId,
//            @PathVariable Long teacherId
//    ) {
//        Subject subject = subjectRepository.findById(subjectId).get();
//        Teacher teacher = teacherRepository.findById(teacherId).get();
//        subject.setTeacher(teacher);
//        return subjectRepository.save(subject);
//    }
}
