package com.educatex.lms.service;

import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.exception.NotFoundException;
import com.educatex.lms.model.Book;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.BookRepository;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.repository.ProfessorRepository;
import com.educatex.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.educatex.lms.common.mappers.CourseMapper.toCourseDTO;

@Slf4j
//@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private BookRepository bookRepository;

    public CourseServiceImpl(CourseRepository courseRepository, BookRepository bookRepository) {
        this.courseRepository = courseRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<CourseDTO> getCourses(){
        return courseRepository.findAll().stream().map(course->{
            return toCourseDTO(course);
        }).collect(Collectors.toList());
    }

    @Override
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(()-> {
            log.error("Course could not be found , id: ",id);
            return new NotFoundException("Course with id " + id + " not found");
        });
    }

    @Override
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    @Override
    public boolean isStudentEnrolled(Long courseId,Student student) {
        Course course=getCourseById(courseId);
        Set<Student> students=course.getEnrolledStudents();

        return students.contains(student)?true:false;
    }

    @Override
    public String printCourseInfo(Course course) {
        return course.toString();
    }

    @Override
    public Professor courseProfessor(Long courseId) {
        Course course=getCourseById(courseId);
        return course.getProfessor();
    }

    @Override
    public CourseDTO findCourseById(Long courseId){
       Course course=courseRepository.findById(courseId).orElseThrow(()-> {
           log.error("Course could not be found , id: ",courseId);
           return new NotFoundException("Course with id " + courseId + " not found");
       });

       return toCourseDTO(course);
    }

    @Override
    public void assignBookToCourse(Long courseId, Long bookId) {
        Book book=bookRepository.findById(bookId).orElseThrow(()->{
            log.error("Book could not be found , id : ",bookId);
            return new NotFoundException("Book with id "+bookId+ "not found");
        });

        Course course=getCourseById(courseId);

        course.setBookToCourse(book);

        saveCourse(course);
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

}

