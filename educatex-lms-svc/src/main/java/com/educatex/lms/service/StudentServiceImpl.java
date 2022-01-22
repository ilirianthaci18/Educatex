package com.educatex.lms.service;

import com.educatex.lms.model.Course;
import com.educatex.lms.model.Student;
import com.educatex.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentdById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student findStudent=getStudentdById(id);
        //here should impl objectMapper

        return findStudent;
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
    public void orari() {

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
}
