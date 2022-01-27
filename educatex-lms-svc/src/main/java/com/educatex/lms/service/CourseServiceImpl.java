package com.educatex.lms.service;

import com.educatex.lms.common.dto.CourseDTO;
import com.educatex.lms.model.Book;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.BookRepository;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.repository.ProfessorRepository;
import com.educatex.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.educatex.lms.common.mappers.CourseMapper.toCourseDTO;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private StudentService studentService;
    private ProfessorService professorService;
    private BookRepository bookRepository;

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
        return courseRepository.findById(id).get();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public Course editCourse(Long id,Course course){
        Course course2=getCourseById(id);
        //obj mapper

        return course;
    }

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
    }

    @Override
    public Professor courseProfessor(Long courseId) {
        Course course=getCourseById(courseId);
        return course.getProfessor();
    }

    @Override
    public void addStudentToSubject(Long courseId,Long studentId,String courseCode){
//        validateInputs(courseId);
//        validateInputs(studentId);
//
//        Course course=getCourseById(courseId);
//        Student student = studentService.getStudentdById(studentId);
//
//        if(courseCode.equals(course.getCourseCode()))
//            course.addEnrolledStudents(student);
//        else
//            //throw exception
//            return null;
//
//        return saveCourse(course);
        Student student=studentService.getStudentdById(studentId);

        Course course=courseRepository.findById(courseId).get();

        course.getEnrolledStudents().add(student);

         saveCourse(course);
    }

    @Override
    public void assignProfessorToSubject(Long courseId, Long professorId) {
//        validateInputs(courseId);
//        validateInputs(professorId);

        Course course=getCourseById(courseId);
        Professor professor= professorService.getProfessorById(professorId);

        course.setProfessor(professor);

         saveCourse(course);
    }

    public CourseDTO findCourseById(Long courseId){
       Course course=courseRepository.findById(courseId).get();
       return toCourseDTO(course);
    }

    @Override
    public void assignBookToCourse(Long courseId, Long bookId) {
        Book book=bookRepository.findById(bookId).get();
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

