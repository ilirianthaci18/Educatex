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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.educatex.lms.common.mappers.CourseMapper.toCourseDTO;

@Slf4j
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private BookRepository bookRepository;

    @Override
    public List<CourseDTO> getCourses(){

        List<Course> courses=courseRepository.findAll();
        List<CourseDTO> courseDTOS=new ArrayList<>();

        courses.stream().forEach(course -> {
            courseDTOS.add(toCourseDTO(course));
        });

        return courseDTOS;

    }

    @Override
    public Course findCourseId(Long id) {
        //TODO find usage
        return courseRepository.findById(id).get();
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
    public void printCourseInfo(Course course) {
        System.out.println(course.toString());
    } // TODO RETURN STRING

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

    private String validateInputs(Long id){

        //string should be replaced with exception
        return id==null?"Cannot make null":"good";
    }
}

