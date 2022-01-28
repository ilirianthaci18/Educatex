package com.educatex.lms.service;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.exception.ApiRequestException;
import com.educatex.lms.exception.NotFoundException;
import com.educatex.lms.model.Course;
import com.educatex.lms.model.Forum;
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
    private PostRepository postRepository;

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
        return studentRepository.findById(id).orElseThrow(() -> {
            log.error("Student could not be found , id : ", id);
            return new NotFoundException("Student with id " + id + "not found");
        });
    }

    @Override
    public StudentDTO getStudentDTOById(Long id) {
        return toStudentDTOWithCourses(getStudentdById(id));
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void addPostToStudent(Long studentId,Long postId) {
        Student student=getStudentdById(studentId);
        Post post=postRepository.findById(postId).orElseThrow(() -> {
            log.error("Post could not be found , id : ", postId);
            return new NotFoundException("Post with id " + postId + "not found");
        });

        student.addPost(post);

        saveStudent(student);

        log.info("Student made a post ",student,post);
    }

    @Override
    public void deleteStudent(Long id) {
       studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents(){
        studentRepository.deleteAll();
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
    public String showStudentInfo(Long id) {
        return getStudentdById(id).toString();
    }

    @Override
    public void showReccomentation() {

    }

    @Override
    public boolean iRregullt(Student std) {
        return false;
        // TODO
    }

}
