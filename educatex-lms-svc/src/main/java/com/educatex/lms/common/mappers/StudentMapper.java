package com.educatex.lms.common.mappers;

import com.educatex.lms.common.dto.StudentDTO;
import com.educatex.lms.common.dto.StudentDTOCourse;
import com.educatex.lms.model.Student;
import org.modelmapper.ModelMapper;

import static com.educatex.lms.common.mappers.CourseMapper.toCourseDTOForStudents;
import static com.educatex.lms.common.mappers.PostMapper.postDTOforStudent;

public class StudentMapper {

    public static StudentDTOCourse toStudentDTO(Student student){
        ModelMapper modelMapper=new ModelMapper();
        StudentDTOCourse studentDTO = modelMapper.map(student,StudentDTOCourse.class);

        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        studentDTO.setGender(student.getGender());
        studentDTO.setPersonalNum(student.getPersonalNum());
        studentDTO.setStudentCreatedAt(student.getStudentCreatedAt());

        return studentDTO;
    }

    public static StudentDTO toStudentDTOWithCourses(Student student){
        ModelMapper modelMapper=new ModelMapper();
        StudentDTO studentDTO = modelMapper.map(student,StudentDTO.class);

        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        studentDTO.setGender(student.getGender());
        studentDTO.setPersonalNum(student.getPersonalNum());
        studentDTO.setStudentCreatedAt(student.getStudentCreatedAt());

        student.getCourses().stream().forEach(course->{
            studentDTO.addCourses(toCourseDTOForStudents(course));
        });

        student.getPosts().stream().forEach(post -> {
            studentDTO.getPosts().add(postDTOforStudent(post));
        });

        return studentDTO;
    }

}
