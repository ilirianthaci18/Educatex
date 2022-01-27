package com.educatex.lms.service;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Post;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.repository.PostRepository;
import com.educatex.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.educatex.lms.common.mappers.StudentMapper.toStudentDTOWithCourses;

@AllArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;//TODO SERVICE
    private PostRepository postRepository; //TODO FORUM SERVICE

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students=studentRepository.findAll();

        List<StudentDTO> studentDTOS=new ArrayList<>();

        students.stream().forEach(student -> {
            studentDTOS.add(toStudentDTOWithCourses(student));
        });

        return studentDTOS;
    }

    @Override
    public Student getStudentdById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public StudentDTO getStudentDTOById(Long id) {
        return toStudentDTOWithCourses(studentRepository.findById(id).get());
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
//        Student findStudent=getStudentdById(id);
        //here should impl objectMapper

        return null;
    }

    @Override
    public void deleteStudent(Long id) {
       studentRepository.deleteById(id);
    }

    @Override
    public int viewAttendence(Course course) {
        return 0;
    }

    @Override
    public List<LocalDateTime> orari(Student student) {
        Set<Course> courseSet=student.getCourses();

        List<LocalDateTime> scheducle=new ArrayList<>();

        courseSet.stream().forEach(course->{
            scheducle.add(course.getDateTime());
        });

        return  scheducle;
    }

    @Override
    public void showStudentInfo(Long id) {

    }

    @Override
    public void showReccomentation() {

    }

    @Override
    public boolean iRregullt(Student std) {
        return false;
    }

    @Override
    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    @Override
    public void addCourseToStudent(Long studentId,Long courseId) {
        Student student=studentRepository.findById(studentId).get();
        Course course=courseRepository.findById(courseId).get();

        student.getCourses().add(course);

        saveStudent(student);
    }

    @Override
    public void addPostToStudent(Long studentId,Long postId) {
        Student student=getStudentdById(studentId);
        Post post=postRepository.findById(postId).get();

        student.addPost(post);

        saveStudent(student);
    }

}
