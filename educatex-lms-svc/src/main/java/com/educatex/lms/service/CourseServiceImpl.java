package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Professor;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.repository.ProfessorRepository;
import com.educatex.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
//    private StudentRepository studentRepository;
//    private ProfessorRepository professorRepository;
    private StudentService studentService;
    private ProfessorService professorService;

    public List<Course> getCourses(){
       return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public Course editCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    @Override
    public boolean isStudentEnrolled(Long courseId,Student student) {
        Course course=findCourseById(courseId);
        Set<Student> students=course.getEnrolledStudents();

        return students.contains(student)?true:false;
    }

    @Override
    public void printCourseInfo(Course course) {
        System.out.println(course.toString());
    }

    @Override
    public Professor courseProfessor(Long courseId) {
        Course course=findCourseById(courseId);
        return course.getProfessor();
    }

    @Override
    public Course addStudentToSubject(Long courseId,Long studentId,String courseCode){
        validateInputs(courseId);
        validateInputs(studentId);

        Course course=findCourseById(courseId);
        Student student = studentService.getStudentdById(studentId);

        if(courseCode.equals(course.getCourseCode()))
            course.addEnrolledStudents(student);
        else
            //throw exception
            return null;

        return saveCourse(course);
    }

    @Override
    public Course assignProfessorToSubject(Long courseId, Long professorId) {
        validateInputs(courseId);
        validateInputs(professorId);

        Course course=findCourseById(courseId);
        Professor professor= professorService.getProfessorById(professorId);

        course.setProfessor(professor);

        return saveCourse(course);
    }

    public Course findCourseById(Long courseId){
        return courseRepository.findById(courseId).get();
    }

    private String validateInputs(Long id){

        //string should be replaced with exception
        return id==null?"Cannot make null":"good";
    }
}

