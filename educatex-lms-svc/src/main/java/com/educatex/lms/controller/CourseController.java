package com.educatex.lms.controller;

import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/course")
@RestController
public class CourseController {

    private CourseService courseService;
    private CourseRepository courseRepository;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<CourseDTO> getAllCourse(){
        return courseService.getCourses();
    }

    @PostMapping()
    public Course saveCourse(@RequestBody @Valid Course course){
        return courseService.saveCourse(course);
    }

    @PutMapping("/{id}")
    public Course editCourse(@PathVariable Long id,@RequestBody @Valid Course course){
        return courseService.editCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable Long courseId){
        return courseService.findCourseById(courseId);
    }

    @GetMapping("/professor/{courseId}")
    public Professor getProfessorOfCourse(@PathVariable Long courseId){
        return courseService.courseProfessor(courseId);
    }

    @GetMapping("/{studentId}/course/{courseId}")
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId){
         courseService.addStudentToSubject(courseId,studentId,"asd");
    }

    @PostMapping("{courseId}/professor/{professorId}")
    public void addProfessorToCourse(@PathVariable Long courseId,@PathVariable Long professorId){
        courseService.assignProfessorToSubject(courseId,professorId);
    }

    @PostMapping("{courseId}/book/{bookId}")
    public void addBookToCourse(@PathVariable Long courseId,@PathVariable Long bookId){
        courseService.assignBookToCourse(courseId,bookId);
    }

}

//    @PostMapping("/{courseId}/students/{studentId}/{courseCode}")
//    public Course addStudentToSubject( @PathVariable Long courseId,@PathVariable Long studentId,@PathVariable String courseCode){
//        courseService.addStudentToSubject(courseId,studentId,courseCode);
//    }
//
//    @PostMapping("/{courseId}/professor/{teacherId}")
//    Course assignTeacherToSubject( @PathVariable Long subjectId,@PathVariable Long teacherId){
//        return courseService.assignProfessorToSubject(subjectId,teacherId);
//    }
