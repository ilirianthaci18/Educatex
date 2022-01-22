package com.educatex.lms.controller;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    CourseService courseService;

    @GetMapping()
    public List<Course> getAllCourse(){
        return courseService.getCourses();
    }

    @GetMapping("{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return courseService.findCourseById(courseId);
    }

    @GetMapping("professor/{courseId}")
    public Professor getProfessorOfCourse(@PathVariable Long courseId){
        return courseService.courseProfessor(courseId);
    }

    @PostMapping()
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @PostMapping("{courseId}/students/{studentId}/{courseCode}")
    public Course addStudentToSubject( @PathVariable Long courseId,@PathVariable Long studentId,@PathVariable String courseCode){
       return courseService.addStudentToSubject(courseId,studentId,courseCode);
    }

    @PostMapping("{courseId}/professor/{teacherId}")
    Course assignTeacherToSubject( @PathVariable Long subjectId,@PathVariable Long teacherId){
        return courseService.assignProfessorToSubject(subjectId,teacherId);
    }

    @PutMapping()
    public Course editCourse(@RequestBody Course course){
        return courseService.editCourse(course);
    }

    @DeleteMapping
    public ResponseEntity deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
