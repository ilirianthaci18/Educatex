package com.educatex.lms.controller;

import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.service.CourseService;
import com.educatex.lms.service.EnrollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/course")
@RestController
public class CourseController {

    private CourseService courseService;
    private EnrollService enrollService;

    @GetMapping()
    public List<CourseDTO> getAllCourse(){
        return courseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable Long courseId){
        return courseService.findCourseById(courseId);
    }

    @GetMapping("/professor/{courseId}")
    public Professor getProfessorOfCourse(@PathVariable Long courseId){
        return courseService.courseProfessor(courseId);
    }

    @PutMapping()
    public Course editCourse(@RequestBody @Valid Course course){
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public Course saveCourse(@RequestBody @Valid Course course){
        return courseService.saveCourse(course);
    }

    @PostMapping("{courseId}/book/{bookId}")
    public void addBookToCourse(@PathVariable Long courseId,@PathVariable Long bookId){
        courseService.assignBookToCourse(courseId,bookId);
    }

    @PostMapping("/{studentId}/course/{courseId}")
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId){
        //TODO enroll with courseCode
        enrollService.addStudentToSubject(courseId,studentId,"asd");
    }

    @PostMapping("/{studentId}/course/{courseId}/remove")
    public void removeStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        enrollService.unEnrollStudentFromSubject(courseId,studentId);
    }

    @PostMapping("{courseId}/professor/{professorId}")
    public void addProfessorToCourse(@PathVariable Long courseId,@PathVariable Long professorId){
        enrollService.assignProfessorToSubject(courseId,professorId);
    }

}

