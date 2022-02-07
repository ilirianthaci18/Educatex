package com.educatex.lms.service;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.common.dto.StudentDTOCourse;
import com.educatex.lms.exception.ApiRequestException;
import com.educatex.lms.exception.NotFoundException;
import com.educatex.lms.model.*;
import com.educatex.lms.repository.CourseRepository;
import com.educatex.lms.repository.PostRepository;
import com.educatex.lms.repository.SearchRepository;
import com.educatex.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.educatex.lms.common.mappers.StudentMapper.*;

@AllArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private PostRepository postRepository;
    private SearchRepository searchRepository;

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
    public Search saveSearch(Search search) {
        //TODO send this to addSearchToStudent
        return searchRepository.save(search);
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
    public void addSearchToStudent(Long studentId, Long searchId) {
        //TODO accept search as object
        Student student=getStudentdById(studentId);
        Search search=searchRepository.findById(searchId).orElseThrow(() -> {
            log.error("Search could not be found , id : ", searchId);
            return new NotFoundException("Search with id " + searchId + "not found");
        });

        student.addSearch(search);

        saveStudent(student);

        log.info("Search made by student was saved ",student,search);
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
//        return searchRepository.findAll();
    }

    @Override
    public boolean iRregullt(Student std) {
        return std.isIRregullt();
    }

    @Override
    public List<StudentDTOCourse> findAllByFirstName(String firstName) {
        List<Student> students=studentRepository.findAllByFirstName(firstName);

        return students.stream().map(student -> {
            return toStudentDTO(student);
        }).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTOCourse> findAllByLastName(String name) {
        List<Student> students= studentRepository.findAllByLastName(name);

        return students.stream().map(student -> {
            return toStudentDTO(student);
        }).collect(Collectors.toList());
    }

    @Override
    public Integer countStudents() {
        return studentRepository.countStudents();
    }

    @Override
    public List<StudentDTOCourse> findAllRegularStudents(boolean rregullt) {
        List<Student> students= studentRepository.findAllRegularStudents(rregullt);

        return students.stream().map(student -> {
            return toStudentDTO(student);
        }).collect(Collectors.toList());
    }

    @Override
    public String showReccomendation(Student student) {
        return student.getSearches().toString();
    }
}
