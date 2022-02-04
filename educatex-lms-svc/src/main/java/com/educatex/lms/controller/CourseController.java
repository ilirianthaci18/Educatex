package com.educatex.lms.controller;

import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.service.CourseService;
import com.educatex.lms.service.EnrollService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(originPatterns = "*")
@AllArgsConstructor
@RequestMapping("/api/course")
@RestController
public class CourseController {

    private CourseService courseService;
    private EnrollService enrollService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping()
    public List<CourseDTO> getAllCourse(){
        return courseService.getCourses();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/{courseId}")
    public CourseDTO getCourseById(@PathVariable Long courseId){
        return courseService.findCourseById(courseId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @GetMapping("/professor/{courseId}")
    public Professor getProfessorOfCourse(@PathVariable Long courseId){
        return courseService.courseProfessor(courseId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @PutMapping()
    public Course editCourse(@RequestBody @Valid Course course){
        return courseService.saveCourse(course);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @PostMapping()
    public Course saveCourse(@RequestBody @Valid Course course){
        return courseService.saveCourse(course);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PROFESSOR')")
    @PostMapping("{courseId}/book/{bookId}")
    public void addBookToCourse(@PathVariable Long courseId,@PathVariable Long bookId){
        courseService.assignBookToCourse(courseId,bookId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/{studentId}/course/{courseId}/{courseCode}")
    public void addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId,@PathVariable String courseCode){
        enrollService.addStudentToSubject(courseId,studentId,courseCode);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT','ROLE_PROFESSOR')")
    @PostMapping("/{studentId}/course/{courseId}/remove")
    public void removeStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        enrollService.unEnrollStudentFromSubject(courseId,studentId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("{courseId}/professor/{professorId}")
    public void addProfessorToCourse(@PathVariable Long courseId,@PathVariable Long professorId){
        enrollService.assignProfessorToSubject(courseId,professorId);
    }

}

